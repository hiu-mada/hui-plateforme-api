package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.Response;
import com.hui.plateform.hiuplateformeapi.entity.dto.TeamListGroupBySubject;
import com.hui.plateform.hiuplateformeapi.repository.ResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponseService {
    private ResponseRepository responseRepository;

    public List<Response> getAllResponse(){
        return responseRepository.findAll();
    }
    public Response getResponseById(String id){
        return responseRepository.findById(id).orElse(null);
    }
    public Response createUpdateResponse(Response response){
        return responseRepository.save(response);
    }
    public void deleteResponse(String id){
        responseRepository.deleteById(id);
    }
    public List<TeamListGroupBySubject> getTeamListGroupBySubject(){
        return responseRepository.getTeamListGroupBySubject();
    }
}
