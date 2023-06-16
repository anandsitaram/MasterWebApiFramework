package com.api;

import com.tricentis.api.pojo.Shops;
import com.tricentis.api.util.ApiUtil;
import com.tricentis.api.util.RestUtils;
import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.testdata.JsonData;
import com.tricentis.common.testing.Validate;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

public class DemoTest extends BaseApiTest {


    @Test
    public void testPost(){

        Map<String, Object> data = JsonData.readMapTestData("testPost");
        Shops shopRequest= Shops.buildRequest(data);
        Response response = RestUtils.executePostRequest("/api/Shops_V4", shopRequest);
        Shops shopResponse = response.as(Shops.class);
        Validate.assertThat(response.statusCode(), Matchers.equalTo(200));
        Validate.assertThat(shopResponse.getCity(), Matchers.equalTo(data.get("city").toString()));

    }

    @Test
    public void testNoBodyPost(){


        Response response = RestUtils.executePostRequest("/api/Shops_V4", "");
        Validate.assertThat(response.statusCode(), Matchers.equalTo(400));
        Validate.assertThat(response.statusLine(), Matchers.containsString(("Bad Request")));


    }

    @Test
    public void testPostRandom(){

        Shops shopRequest= Shops.buildRandomRequest();
        Response response = RestUtils.executePostRequest("/api/Shops_V4", shopRequest);
        Validate.assertThat(response.statusCode(), Matchers.equalTo(200));

    }

    @Test
    public void testPostFromFile(){

        String payLoad= ApiUtil.readRequestFromFile(FrameworkConstants.TEST_RESOURCE_PATH+ "/request.json");

        Response response = RestUtils.executePostRequest("/api/Shops_V4", payLoad);
        ApiUtil.saveResponseToFile(FrameworkConstants.TEST_RESOURCE_PATH+"/response.json",response.prettyPrint());
        Validate.assertThat(response.statusCode(), Matchers.equalTo(200));

    }

    @Test
    public void testPut(){

        Map<String, Object> data = JsonData.readMapTestData("testPut");
        Shops shopRequest= Shops.buildRequest(data);
        Response response = RestUtils.executePutRequest("/api/Shops_V4", shopRequest);
        Shops shopResponse = response.as(Shops.class);
        Validate.assertThat(response.statusCode(), Matchers.equalTo(200));
        Validate.assertThat(shopResponse.getCity(), Matchers.equalTo(data.get("city").toString())); Validate.assertThat(response.statusCode(), Matchers.equalTo(200));

    }

    @Test
    public void testDelete(){
        Response response = RestUtils.executeDeleteRequestUsingPathParam("/api/Shops_V4", "id",4);
        Validate.assertThat(response.statusCode(), Matchers.equalTo(204));

    }

    @Test
    public void testGetSingleShops(){
        Response response = RestUtils.executeGetRequestUsingPathParam("/api/Shops_V4","id",1);
        Shops shopResponse = response.as(Shops.class);
        Validate.assertThat(response.statusCode(), Matchers.equalTo(200));
        Validate.assertThat(shopResponse.getId(), Matchers.equalTo(Long.valueOf(1)));

    }
}