package com.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {


    /**
     * Versioning with URI (Twitter)*/
    @GetMapping("/v1/person")
    public PersonV1 GetFirstVersion(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 GetSecondVersion(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }


    /**Params (Amazon)*/
    @GetMapping(value = "/person",params = "version=1")
    public PersonV1 GetFirstVersionReqParams(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person",params = "version=2")
    public PersonV2 GetSecondVersionReqParams(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }


    /**
     * Headers (Custom (Microsoft))*/
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 GetFirstVersionReqHeader(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 GetSecondVersionReqHeader(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }


    /**
     * Accept Headers (Media type versioning (Github))**/
    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 GetFirstVersionAcceptHeader(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 GetSecondVersionAcceptHeader(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
