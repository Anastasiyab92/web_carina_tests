package com.solvd.carina.demo.soap;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@RequestTemplatePath(path = "api/soap/addinteger/rq.xml")
@ResponseTemplatePath(path = "api/soap/addinteger/rs.xml")
@ContentType(type = "text/xml")
public class AddIntegerMethod extends AbstractApiMethodV2 {

    public AddIntegerMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("soap_url"));
        setHeaders(String.format("SOAPAction=%s", "http://tempuri.org/SOAP.Demo.AddInteger"));
    }

}
