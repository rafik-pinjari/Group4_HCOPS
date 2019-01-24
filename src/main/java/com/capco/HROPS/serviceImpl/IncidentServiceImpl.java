package com.capco.HROPS.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.custom.exception.HcopsException.ResourceNotFoundException;
import com.capco.HROPS.model.Incident;
import com.capco.HROPS.model.Mail;
import com.capco.HROPS.model.Request;
import com.capco.HROPS.repository.IncidentRepository;
import com.capco.HROPS.repository.ReqRepository;
import com.capco.HROPS.service.IncidentService;
import com.capco.HROPS.service.MailSendService;


@Service
public class IncidentServiceImpl implements IncidentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@SuppressWarnings("unused")
	private static String UPLOAD_FOLDER = "C:\\Users\\e5544325\\Downloads\\spring-boot-mysql-rest-api-tutorial-master\\spring-boot-mysql-rest-api-tutorial-master\\assets\\";

	@Autowired
	private IncidentRepository incident1Repository;

	@Autowired
	private ReqRepository requestRepository;
	
	@Autowired
	private Mail mail;
	
	@Autowired
	private MailSendService mailSendService;

	@Override
	public Incident createNewIncident(Incident incident1) throws Exception {

		try {
			logger.info("IncidentServiceImpl: createNewIncident : started");

			incident1.setStatus("open");
			List<Request> list;
			if (incident1.getRequest() == null) {
				list = new ArrayList<>();
				incident1.setRequest(list);
			}
			list = incident1.getRequest();
			for (Request d : list) {
				d.setIncident1(incident1);

			}

			String incid = incident1Repository.getid();
			int i;
			int id;
			String inci;
			if (incid == null) {
				incident1.setId(1);
				inci = "INC" + 1;
				incident1.setIncidentId(inci);
			} else {
				i = Integer.parseInt(incid);
				id = i + 1;
				incident1.setId(id);
				inci = "INC" + id;
				incident1.setIncidentId(inci);
			}

			// byte[] bytes=null;
			// if (file.isEmpty()) {
			//
			// return null;
			// }
			// else
			// {
			// try {
			// // read and write the file to the selected location-
			// bytes = file.getBytes();
			// Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			// Files.write(path, bytes);
			// }
			// catch (IOException e) {
			// e.printStackTrace();
			// }
			// }
			// incident1.setFileName(file.getOriginalFilename());
			//
			
			

			Incident inc= incident1Repository.save(incident1);
			
			
			
			
			if(inc!=null) {
				/*List<Request> req = null;
				String description = null;
				list = inc.getRequest();
				for (Request d : req) {
					
					description = d.getDescription();
				}*/
				//System.out.println("description: "+description);
				String receiver="anaghasonawane545@gmail.com";
				String subject="Incident "+inc.getIncidentId()+" has been opened";
				String body="An incident ";
				
				mail.setBody(body);
				mail.setReicever(receiver);
				mail.setSubject(subject);
			
				mailSendService.sendMail(mail);
			}
			
			
			
			return inc;		

		} catch (ResourceNotFoundException e) {
			logger.error("IncidentServiceImpl : createNewIncident: Exception Caught: " , e);
			throw new HcopsServiceException(e);
		}
	}

	@Override
	public Incident getIncidentById(String incidentId) throws HcopsServiceException {
		try {
			logger.info("IncidentServiceImpl: getIncidentById : started");
			Incident incident1 = incident1Repository.findAllByincidentId(incidentId);
			if (incident1 == null) {
				logger.error("IncidentServiceImpl : getIncidentById: Empty Object: ");
				return null;
			} else {
				logger.info("IncidentServiceImpl: getIncidentById : ended");
				return incident1;
			}
		} catch (ResourceNotFoundException e) {
			logger.error("IncidentServiceImpl : getIncidentById: Exception Caught: " , e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public List<Incident> findAllByuserId(String userId) throws HcopsServiceException {

		try {
			logger.info("IncidentServiceImpl: findAllByuserId : started");

				List<Incident> incident1 = incident1Repository.findAllByuserId(userId);
				logger.info("IncidentServiceImpl: findAllByuserId : ended");
				return incident1;
			

		} catch (ResourceNotFoundException e) {
			logger.error("IncidentServiceImpl : findAllByuserId: Exception Caught: " , e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public List<Incident> getAllIncidents() throws HcopsServiceException {
		try {
			logger.info("IncidentServiceImpl: getAllIncidents : started");
			return incident1Repository.findAll();
			

		} catch (ResourceNotFoundException e) {
			logger.error("IncidentServiceImpl : getAllIncidents: Exception Caught: " , e);
			throw new HcopsServiceException(e);
		}
	}

	@Override
	public Boolean deleteincidentId(String incidentId) throws HcopsServiceException {

		try {
			logger.info("IncidentServiceImpl: deleteincidentId : started");
			Incident incident1 = incident1Repository.findAllByincidentId(incidentId);
			if (incident1 == null) {
				logger.error("IncidentServiceImpl : deleteincidentId: empty incident object: ");

				return false;
			} else {
				incident1Repository.delete(incident1);
				logger.info("IncidentServiceImpl: deleteincidentId : ended");
				return true;
			}
		} catch (ResourceNotFoundException e) {
			logger.error("IncidentServiceImpl : deleteincidentId: Exception Caught: " + e);
			throw new HcopsServiceException(e);
		}
	}

	@Override
	public Boolean closeIncident(String incidentId) throws HcopsServiceException {
		
		try {
			logger.info("IncidentServiceImpl: closeIncident : started");
				Incident inc = incident1Repository.findAllByincidentId(incidentId);
				if(inc==null) {
					logger.error("IncidentServiceImpl : deleteincidentId: empty incident object: ");
					return false;
				}
				else {
				inc.setStatus("closed");
				incident1Repository.save(inc);
				logger.info("IncidentServiceImpl: closeIncident : ended");
				return true;
			}
		}
		 catch (ResourceNotFoundException e) {
				logger.error("IncidentServiceImpl : deleteincidentId: Exception Caught: " + e);
				throw new HcopsServiceException(e);
			}
		
	}
	
	@Override
	public List<Incident> getLocation(String location) throws HcopsServiceException {
		try {
			logger.info("IncidentServiceImpl: getLocation : started");
			List<Incident> incident1 = incident1Repository.findAllBylocation(location);
			
				logger.info("IncidentServiceImpl: getLocation : ended");
				return incident1;
			
		} catch (ResourceNotFoundException e) {
			logger.error("IncidentServiceImpl : getLocation: Exception Caught: " + e);
			throw new HcopsServiceException(e);
		}
	}

	@SuppressWarnings("unused")
	@Override
	public Incident reopenIncident(String incidentId, Incident incident1)
			throws HcopsServiceException, ParseException, NullPointerException {
		logger.info("IncidentServiceImpl: reopenIncident : started");
		try {
			Incident inc = incident1Repository.findAllByincidentId(incidentId);

			List<Request> list;
			String desc = null;
			list = incident1.getRequest();
			for (Request d : list) {

				desc = d.getDescription();
			}

			final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();


			Date d2 = inc.getCreatedAt();

			Date date1 = null;

			date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(date));

			long dif = date1.getTime() - d2.getTime();

			long diffHours = dif / (60 * 60 * 1000);

			if (diffHours >= 48) {
				logger.error("IncidentServiceImpl : reopenIncident: Incident cannot reopen: ");

				return null;
			} else {

				inc.setStatus("reOpen");
				incident1Repository.save(inc);

				requestRepository.setStatus(desc, incidentId);
				Incident updatedInc = incident1Repository.findAllByincidentId(incidentId);
				logger.info("IncidentServiceImpl: reopenIncident : ended");
				return updatedInc;
			}

		} catch (ResourceNotFoundException e) {
			logger.error("IncidentServiceImpl : reopenIncident: Exception Caught: " + e);
			throw new HcopsServiceException(e);
		}

	}

	public List<Incident> getIncidentByDate(String date) throws HcopsServiceException {
		logger.info("Incident1Controller : getIncidentByDate: started");

		try {
			List<Incident> incident1 = incident1Repository.getDate(date);

				logger.info("Incident1Controller : reopenIncident: ended");
				return incident1;
			

		} catch (Exception e) {
			logger.error("Incident1Controller : reopenIncident: Exception Caught" , e);
			throw new HcopsServiceException(e);
		}

	}

	
}
