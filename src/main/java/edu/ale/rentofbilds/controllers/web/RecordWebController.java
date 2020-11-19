package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/record/")
public class RecordWebController {
    @Autowired
    ServiceRecordMongoImpl service;



}
