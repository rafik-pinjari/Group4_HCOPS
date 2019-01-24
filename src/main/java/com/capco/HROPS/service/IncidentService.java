package com.capco.HROPS.service;

import java.text.ParseException;
import java.util.List;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.Incident;


public interface IncidentService {
	
	public Incident createNewIncident(Incident incident1) throws HcopsServiceException, Exception;
	
	public Incident getIncidentById(String incidentId) throws HcopsServiceException;

	public List<Incident> findAllByuserId(String userId) throws HcopsServiceException;
	
	public List<Incident> getAllIncidents() throws HcopsServiceException;

	public Boolean deleteincidentId(String incidentId) throws HcopsServiceException;
	
	public List<Incident> getLocation(String location) throws HcopsServiceException;
	
	public Incident reopenIncident(String incidentId,Incident incident1) throws HcopsServiceException, ParseException, NullPointerException; 
	
	public List<Incident> getIncidentByDate(String date) throws HcopsServiceException;
	
	public Boolean closeIncident(String incidentId) throws HcopsServiceException;
		
}
