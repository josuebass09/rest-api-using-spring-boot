package com.example.restcalculatorbyjosuehr.controller;
import com.example.restcalculatorbyjosuehr.model.*;
import com.example.restcalculatorbyjosuehr.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @Autowired
    private GenericService userService;

    /**
     * Gets a request from operations/addition endpoint with v1,v2 as required params and round as optional.
     * it returns a JSON object which contains the addition result
     * @param v1
     * @param v2
     * @param round
     * @return ResponseEntity
     */
    @RequestMapping(value = "operations/addition",method = RequestMethod.GET)
    public ResponseEntity<Response> getAdditionResult(@RequestParam(value = "v1",required = true)Double v1,@RequestParam(value = "v2",required = true)Double v2,@RequestParam(value = "round",required = false,defaultValue = "2")int round)
    {
        Addition addition = new Addition(v1,v2);
        Double result = addition.calculate();
        Response response = new Response();
        response.setDataFormat(round,result);
        response.setMessage("Successful Addition");
        return ResponseEntity.ok(response);
    }

    /**
     * Gets a request from operations/subtraction endpoint with v1,v2 as required params and round as optional.
     * it returns a JSON object which contains the subtraction result
     * @param v1
     * @param v2
     * @param round
     * @return ResponseEntity
     */
    @RequestMapping(value = "operations/subtraction",method = RequestMethod.GET)
    public ResponseEntity<Response> getSubtractionResult(@RequestParam(value = "v1",required = true)Double v1,@RequestParam(value = "v2",required = true)Double v2,@RequestParam(value = "round",required = false,defaultValue = "2")int round)
    {
        Subtraction subtraction = new Subtraction(v1,v2);
        Double result = subtraction.calculate();
        Response response = new Response();
        response.setDataFormat(round,result);
        response.setMessage("Successful Subtraction");
        return ResponseEntity.ok(response);
    }

    /**
     * Gets a request from operations/multiplication endpoint with v1,v2 as required params and round as optional.
     * it returns a JSON object which contains the multiplication result
     * @param v1
     * @param v2
     * @param round
     * @return ResponseEntity
     */
    @RequestMapping(value = "operations/multiplication",method = RequestMethod.GET)
    public ResponseEntity<Response> getMultiplicationResult(@RequestParam(value = "v1",required = true)Double v1,@RequestParam(value = "v2",required = true)Double v2,@RequestParam(value = "round",required = false,defaultValue = "2")int round)
    {
        Multiplication multiplication = new Multiplication(v1,v2);
        Double result = multiplication.calculate();
        Response response = new Response();
        response.setDataFormat(round,result);
        response.setMessage("Successful Multiplication");
        return ResponseEntity.ok(response);
    }

    /**
     * Gets a request from operations/division endpoint with v1,v2 as required params and round as optional.
     * it returns a JSON object which contains the division result
     * @param v1
     * @param v2
     * @param round
     * @return ResponseEntity
     */
    @RequestMapping(value = "operations/division",method = RequestMethod.GET)
    public ResponseEntity<Response> getDivisionResult(@RequestParam(value = "v1",required = true)Double v1,@RequestParam(value = "v2",required = true)Double v2,@RequestParam(value = "round",required = false,defaultValue = "2")int round)
    {
        Division division = new Division(v1,v2);
        Double result = division.calculate();
        Response response = new Response();
        response.setDataFormat(round,result);
        response.setMessage("Successful Division");
        return ResponseEntity.ok(response);
    }

    /**
     * Gets a request from /public endpoint which not required an authorization token, so anyone can access
     * it returns a JSON object which contains a simple text
     * @return ResponseEntity
     */
    @RequestMapping(value = "public",method = RequestMethod.GET)
    public ResponseEntity<Response> getPublicData()
    {
        Response response = new Response();
        response.setData("token is not required to access here");
        response.setMessage("Public Access");
        return ResponseEntity.ok(response);
    }
}
