package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.ResponseService;
import com.hui.plateform.hiuplateformeapi.entity.Response;
import com.hui.plateform.hiuplateformeapi.entity.dto.TeamListGroupBySubject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
@AllArgsConstructor
public class ResponseController {
    private ResponseService responseService;

    @GetMapping("/")
    public List<Response> getAllResponse(){
        return responseService.getAllResponse();
    }
    @PostMapping("/")
    public Response createResponse(@RequestBody Response response){
        return responseService.createUpdateResponse(response);
    }
    @GetMapping("/{id}")
    public Response getResponseById(@PathVariable String id){
        return responseService.getResponseById(id);
    }
    @PutMapping("/{id}")
    public Response updateResponse(@PathVariable String id, @RequestBody Response response){
        response.setId(id);
        return responseService.createUpdateResponse(response);
    }
    @DeleteMapping("/{id}")
    public void deleteResponseById(@PathVariable String id){
        responseService.deleteResponse(id);
    }
    @GetMapping("/team-by-subject")
    public List<TeamListGroupBySubject> getTeamListGroupBySubject(){
        return responseService.getTeamListGroupBySubject();
    }
}
