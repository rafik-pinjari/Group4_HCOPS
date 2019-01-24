package com.capco.HROPS.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.Incident;
import com.capco.HROPS.repository.IncidentRepository;
import com.capco.HROPS.service.IncidentService;


@RestController
@RequestMapping("/incident")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class IncidentController {
   
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private IncidentService incidentService;
    
    @Autowired
    IncidentRepository incident1Repository;
    
   
	@RequestMapping(value="/save",method=RequestMethod.POST )
    @ResponseBody
    public ResponseEntity<Incident> createIncident(@Valid @RequestBody Incident incident1, HttpServletRequest request, HttpServletResponse response) throws Exception {
      
    	logger.info("Incident1Controller,{}", incident1);
    	
    	
    	if(incident1==null) {
    		logger.error("Incident1Controller : createIncident: errorEmptyIncidentObject,{}", incident1);
    		return new ResponseEntity("No incident Data ", HttpStatus.NO_CONTENT);
    	}
    	else {
    		try {
    			incidentService.createNewIncident(incident1);
    			logger.info("Incident1Controller : createIncident: ended,{}", incident1);
                return ResponseEntity.ok().body(incident1);
    		}
    		catch(HcopsServiceException e) {
    			logger.error("Incident1Controller : createIncident: Exception Caught,{}" , e);
    			throw new HcopsServiceException(e);
    		}
    		
    	}
        
    }
    
   
	@RequestMapping(value="/getIncidentId/{incidentId}", method=RequestMethod.GET)
    public ResponseEntity<Incident> getIncidentById(@PathVariable(value = "incidentId") String incidentId) throws HcopsServiceException {
    	
    	logger.info("Incident1Controller: getIncidentById : started,{}", incidentId);
    	if(incidentId==null) {
    		logger.error("Incident1Controller : getIncidentById: errorEmptyIncidentObject,{}", incidentId);
    		return new ResponseEntity("empty incidentId Data ", HttpStatus.NO_CONTENT);
    	}
    	else {
    		try {
    			Incident incident1=incidentService.getIncidentById(incidentId);
    			logger.info("Incident1Controller : getIncidentById: ended,{}", incident1);
    	        return ResponseEntity.ok().body(incident1);
    		}
    		catch(HcopsServiceException e) {
    			logger.error("Incident1Controller : getIncidentById: Exception Caught,{}" , e);
    			throw new HcopsServiceException(e);
    		}
    	     
    	}
    }
    
    
	@RequestMapping(value="/getUserId/{userId}", method=RequestMethod.GET)
    public ResponseEntity<List<Incident>> getUserId(@PathVariable(value = "userId") String userId) throws HcopsServiceException {
        logger.info("Incident1Controller: getUserId : started,{}",userId);
        if(userId==null) {
        	logger.error("Incident1Controller : getUserId: errorEmptyUserId,{}", userId);
        	return new ResponseEntity("empty userId Data ", HttpStatus.NO_CONTENT);
        }
        else {
        	try {
        		List<Incident> incident1=incidentService.findAllByuserId(userId);
        		if(incident1.isEmpty()) {
        			 logger.error("Incident1Controller : getUserId: errorEmptyIncidentObject,{}", userId);
						return new ResponseEntity("Empty incident object ", HttpStatus.NO_CONTENT);
        		}
        		else {
        			logger.info("Incident1Controller : getUserId: ended,{}", userId);
                	return ResponseEntity.ok().body(incident1);
        		}
        		
        	}
        	catch(HcopsServiceException e) {
    			logger.error("Incident1Controller : getUserId: Exception Caught,{}" , e);
    			throw new HcopsServiceException(e);
    		}
        	
        	
        }
       
    }
    
    
	@GetMapping("/getAll")
    public ResponseEntity<List<Incident>> getAllIncidents() throws HcopsServiceException {
        logger.info("Incident1Controller: getAllIncidents : started, {}", getAllIncidents());
        List<Incident> incident1=incidentService.getAllIncidents();
        if(incident1.isEmpty()) {
        	logger.error("Incident1Controller : getAllIncidents: errorEmptyIncidentObject,{}", incident1);
        	return new ResponseEntity("Empty incident list data ", HttpStatus.NO_CONTENT);
        }
        else {
        	logger.info("Incident1Controller : getAllIncidents: ended,{}", incident1);
			return ResponseEntity.ok().body(incident1);
        	
        }
    }
    
  
	@DeleteMapping("/deleteIncidentId/{incidentId}")
    public ResponseEntity<?> deleteincidentId(@PathVariable(value = "incidentId") String incidentId) throws HcopsServiceException {
        logger.info("Incident1Controller: deleteincidentId : started,{}", incidentId);
        if(incidentId==null) {
        	logger.error("Incident1Controller : deleteincidentId: errorEmptyIncidentId,{}", incidentId);
        	return new ResponseEntity("Empty inc id Data ", HttpStatus.NO_CONTENT);
    	}
        else {
        	try {
        		Boolean flag=incidentService.deleteincidentId(incidentId);
        		if(flag==false) {
        			logger.error("Incident1Controller : deleteincidentId: errorEmptyReturnIncidentObject,{}", incidentId);
                	return new ResponseEntity("not deleted data ", HttpStatus.NO_CONTENT);
        		}
        		else {
        			logger.info("Incident1Controller: deleteincidentId : ended,{}", incidentId);
                    return ResponseEntity.ok().build();
        		}
            	
        	}
        	catch(HcopsServiceException e) {
    			logger.error("Incident1Controller : deleteincidentId: Exception Caught" , e);
    			throw new HcopsServiceException(e);
    		}
        	
        }
        
    }
    
   
	@RequestMapping(value="/getLocation/{location}", method=RequestMethod.GET)
    public ResponseEntity<List<Incident>> getLocation(@PathVariable(value = "location") String location) throws HcopsServiceException {
    	 logger.info("Incident1Controller: getLocation : started");
    	 if(location==null) {
    		 logger.error("Incident1Controller : getLocation: errorEmptyIncidentLocation");
    		 return new ResponseEntity("Empty location  ", HttpStatus.NO_CONTENT);
     	}
         else {
        	 try {
        		 List<Incident> incident1=incidentService.getLocation(location);
        		 if(incident1.isEmpty()) {
        			 logger.error("Incident1Controller : getLocation: errorEmptyReturnIncidentObject");
                 	return new ResponseEntity("no inc object Data ", HttpStatus.NO_CONTENT);
        		 }
        		 else {
        			 logger.info("Incident1Controller: getLocation : ended");
                	 return ResponseEntity.ok().body(incident1); 
        		 }
            	
        	 }
        	 catch(HcopsServiceException e) {
     			logger.error("Incident1Controller : getLocation: Exception Caught" , e);
     			throw new HcopsServiceException(e);
     		}
        	 
         	 
         }
    }
    
  
	@RequestMapping(value="/reOpen/{incidentId}", method=RequestMethod.POST)
    public ResponseEntity<Incident> reopenIncident(@PathVariable(value = "incidentId") String incidentId,@Valid @RequestBody Incident incident1) throws HcopsServiceException{
    	logger.info("Incident1Controller: reopenIncident : started");
    	if(incidentId==null) {
    		logger.error("IncidentController : reopenIncident: errorEmptyIncidentID");
    		return new ResponseEntity("Empty id ", HttpStatus.NO_CONTENT);
    	}
    	else {
    		if(incident1==null) {
        		logger.error("Incident1Controller : reopenIncident: errorEmptyObject");
        		return new ResponseEntity("Empty Data ", HttpStatus.NO_CONTENT);
        	}
    		else {
    			try {
    				Incident i=incidentService.reopenIncident(incidentId, incident1);
    				if(i==null) {
    					logger.error("Incident1Controller : reopenIncident: errorEmptyIncidentObject");
    	        		
    					return new ResponseEntity("Incident can not open ", HttpStatus.EXPECTATION_FAILED);
    				}
    				else {
    					logger.info("Incident1Controller : reopenIncident: IncidentReopenSuccessfully");
    	        		
    				return ResponseEntity.ok().body(incident1);
    				}
    			}
    			catch(Exception e) {
        			logger.error("Incident1Controller : reopenIncident: Exception Caught" , e);
        			throw new HcopsServiceException(e);
        		}
    		}
    		
    
    	}
    	
    }
    
    
	@GetMapping("/getDate/{date}")
	 public ResponseEntity<List<Incident>> getIncidentByDate(@PathVariable(value = "date") String date) throws HcopsServiceException {
		logger.info("Incident1Controller: getIncidentByDate : started");
		if(date==null) {
			logger.error("Incident1Controller : getIncidentByDate: errorEmptyDate");
			return new ResponseEntity("Empty date ", HttpStatus.NO_CONTENT);
		}
		else {
			try {
				List<Incident> incident1=incidentService.getIncidentByDate(date);
				
				 if(incident1.isEmpty()){
					 logger.error("Incident1Controller : reopenIncident: errorEmptyIncidentObject");
						return new ResponseEntity("Empty Data ", HttpStatus.NO_CONTENT);		 
				
				}
				 else {
						logger.info("Incident1Controller : reopenIncident: IncidentReopenSuccessfully");
	    				return ResponseEntity.ok().body(incident1);
					}

			}
			catch(Exception e) {
    			logger.error("Incident1Controller : reopenIncident: Exception Caught" , e);
    			throw new HcopsServiceException(e);
    		}
		}
		
		 
	 }
	
	@RequestMapping(value="/closeIncident/{incidentId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> closeIncident(@PathVariable(value = "incidentId") String incidentId) throws HcopsServiceException {
		logger.info("Incident1Controller: closeIncident : started");
		if(incidentId==null) {
			logger.error("Incident1Controller : getIncidentByDate: errorEmptyDate");
			return new ResponseEntity("Empty date ", HttpStatus.NO_CONTENT);
		}
		else {
			try {
				
				Boolean flag=incidentService.closeIncident(incidentId);
				
				if(flag==false) {
					logger.error("Incident1Controller : closeIncident: errorEmptyIncidentObject");
					return new ResponseEntity("Empty Data ", HttpStatus.NO_CONTENT);
				}
				else {
					logger.info("Incident1Controller: closeIncident : ended");
					return ResponseEntity.ok().build();
				}
				
			}
			catch(Exception e) {
    			logger.error("Incident1Controller : closeIncident: Exception Caught" , e);
    			throw new HcopsServiceException(e);
    		}
		}
		
		
	}
    
}