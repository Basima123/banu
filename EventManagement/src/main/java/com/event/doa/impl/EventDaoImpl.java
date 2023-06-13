package com.event.doa.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.events.Event;

import com.event.dto.EventDto;
import com.event.dto.PersonDto;

import utility.JdbcConnection;

public class EventDaoImpl {
	private int getPersonId() throws SQLException {
		int personId = 0;
		ResultSet resultSet = null;
		PreparedStatement pst = null;
		Connection con=JdbcConnection.getConnection();
		pst = con.prepareStatement("select max(id) as person_id_val from Person");
		resultSet = pst.executeQuery();
		while(resultSet.next()) {
			System.out.println("getPersonId : "+resultSet.getInt("person_id_val"));
			personId = resultSet.getInt("person_id_val");
		}
		return personId;
	}

	public PersonDto validatePerson(PersonDto person) {
		try {
			ResultSet rs = null;
			PreparedStatement pst = null;
			Connection con=JdbcConnection.getConnection();
			pst = con.prepareStatement
					("select id,name from Person where name=? and password=?");
			pst.setString(1, person.getPersonName());
			pst.setString(2, person.getPassword());
			//rs: [ ["person_id": "101", "person_name" : "nick"]				
			rs = pst.executeQuery();
			while(rs.next()) {
				person.setPersonId(Integer.parseInt(rs.getString("person_id")));
				person.setPersonName(rs.getString("person_name"));
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return person;
	}

	public List<EventDto> listAllEvents() {
		System.out.println("START listAllEvents");
		List<EventDto> eventList = new ArrayList<EventDto>();
			try {
				ResultSet resultSet = null;
				PreparedStatement pst = null;
				Connection con=JdbcConnection.getConnection();
				pst = con.prepareStatement("select * from Event");
				resultSet = pst.executeQuery();
				while (resultSet.next()) {
					// if(eventList.size() < 1) {
					EventDto event = new EventDto();
					event.setEventId(resultSet.getInt("event_id"));
					event.setEventName(resultSet.getString("event_name"));
					//event.setEventdate(resultSet.getString("event_date"));
					//event.setEventTime(resultSet.getString("event_time"));
					event.setVenue(resultSet.getString("venue"));
					eventList.add(event);
					//allEventsList.add(event);
					// }
				}

			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		//}
		System.out.println("END listAllEvents");
		return eventList;
	}

	public List<EventDto> showUserEvents(PersonDto person) {
		System.out.println("START showUserEvents");
		List<EventDto> eventList = listAllEvents();
		List<EventDto> userEventsList = new ArrayList<EventDto>();
		try {
		//	System.out.println("showUserEvents 001");
			ResultSet resultSet = null;
			PreparedStatement pst = null;
			Connection con=JdbcConnection.getConnection();
			pst = con.prepareStatement("select event_id, status from PersonEvents where person_id = ? order by event_id");
			pst.setInt(1, person.getPersonId());
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				//System.out.println("showUserEvents 002 eventList size : "+eventList);
				for(EventDto events : eventList) {
				//	System.out.println("showUserEvents 003");
					if(events.getEventId() == resultSet.getInt("event_id")) {
					//	System.out.println("showUserEvents 004");
						events.setStatus(resultSet.getString("status"));
						userEventsList.add(events);
						//usersEventsList.add(events);
					}
				}
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		System.out.println("END showUserEvents");
		return userEventsList;
	}
		
	public PersonDto getPersonDetails(PersonDto person) {
		try {
			ResultSet resultSet = null;
			PreparedStatement pst = null;
			Connection con=JdbcConnection.getConnection();
			pst = con.prepareStatement("select * from Person where "
					+ "id=?");
			pst.setInt(1, person.getPersonId());
			resultSet = pst.executeQuery();
			while(resultSet.next()) {
				person.setPersonName(resultSet.getString("person_name").toUpperCase());
				person.setDob(resultSet.getString("DOB").toUpperCase());
				person.setGender(resultSet.getString("gender").toUpperCase());
				person.setPersonId(resultSet.getInt("person_id"));
			}
			
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}

		return person;
	}
	
	public boolean savePerson(PersonDto person) {
		//List<Event> userEventsList = new ArrayList();
		boolean isSaved = false;
		try {
			int personId = getPersonId();//104
			System.out.println("savePerson 001 : "+personId);
			Connection connection = JdbcConnection.getConnection();
			PreparedStatement pst = null;
			pst = connection.prepareStatement("insert into person (person_id, person_name, password, gender, DOB) values (?,?,?,?,?) ");
			pst.setInt(1, personId+1);
			pst.setString(2, person.getPersonName());
			pst.setString(3,person.getPassword());
			pst.setString(4, person.getGender());
			pst.setString(5, person.getDob());
			pst.execute();
			System.out.println("savePerson 002");
			connection.commit();
			System.out.println("savePerson 003");
			//userEventsList = showUserEvents(person);
			isSaved = checkRegisteredPerson(person);
			System.out.println("savePerson 004");
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return isSaved;
	}

	public List<Event> updateEvent(Event event, PersonDto person) {
		List<Event> userEventsList = new ArrayList();
		try {
			Connection connection = JdbcConnection.getConnection();
			PreparedStatement pst = null;
			pst = connection.prepareStatement("update PersonEvents set status = ? where event_id = ? and person_id = ? ");
			//pst.setString(1, event.getEventStatus());
			//pst.setInt(2, event.getEventId());
			pst.setInt(3, person.getPersonId());
			pst.execute();
			connection.commit();
			//userEventsList = showUserEvents(person);

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return userEventsList;
	}

	public boolean registerEvent(EventDto event,PersonDto person) {
		boolean isEventRegSuccess = false;
		System.out.println("START registerEvent");
		String[] selectedEventList = event.getEventList();
		for(int i = 0; i<selectedEventList.length; i++) {
			System.out.println("Event Ids need to registered : "+selectedEventList[i]);
		}
		for (int i = 0; i < selectedEventList.length; i++) {
			List<EventDto> eventList = new ArrayList<>();
			event.setEventId(Integer.parseInt(selectedEventList[i]));
			if (checkEventRegisteredAlready(event, person)) {
				isEventRegSuccess = false;
				break;
			} else {
				List<Event> userEventsList = new ArrayList();
				try {
					int personEventId = getPersonEventsId();
					Connection connection = getConnection();
					PreparedStatement pst = null;
					pst = connection.prepareStatement(
							"insert into PersonEvents (ID, person_id, event_id, status) values (?,?,?,?)");
					pst.setInt(1, personEventId);
					pst.setInt(2, person.getPersonId());
					pst.setInt(3, Integer.parseInt(selectedEventList[i]));
					pst.setString(4, "Registered");
					pst.execute();
					connection.commit();
					// userEventsList = showUserEvents(person);
					isEventRegSuccess = true;
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
				System.out.println("Before calling listAllEvents()");
				// eventList = listAllEvents();
			}
		}
		System.out.println("END registerEvent");
		return isEventRegSuccess;
		
	}
	
	private boolean checkEventRegisteredAlready(Event event, PersonDto person) {
		//System.out.println("START checkEventRegisteredAlready");
		//System.out.println("checkEventRegisteredAlready Event Id need to registered : "+event.getEventId());
		boolean isRegAlready = false;
		//System.out.println("usersEventsList size : "+usersEventsList.size());
		List<Event> usersEventsList = showUserEvents(person);
		for (Event userEvents : usersEventsList) {
			System.out.println("listAllEvents : "+userEvents.getEventId()+"----"+userEvents.getEventName()+"-----"+userEvents.getEventDate());
			if(userEvents.getEventId() == event.getEventId()) {
				isRegAlready = true;
			}
		}
		System.out.println("END checkEventRegisteredAlready");
		return isRegAlready;
	}
	
	private int getPersonEventsId() throws SQLException {
		int personEventId = 0;
		ResultSet resultSet = null;
		PreparedStatement pst = null;
		pst = getConnection().prepareStatement("select max(ID) as personEventId from PersonEvents");
		resultSet = pst.executeQuery();
		while(resultSet.next()) {
			System.out.println("registerEvent : "+resultSet.getInt("personEventId"));
			personEventId = resultSet.getInt("personEventId");
		}
		return personEventId;
	}
	
	public boolean checkRegisteredPerson(PersonDto person) {
		boolean isRegistered = false;
		try {
			ResultSet rs = null;
			PreparedStatement pst = null;
			pst = getConnection().prepareStatement("select person_id,person_name from Person where person_name=? and password=?");
			pst.setString(1, person.getPersonName());
			pst.setString(2, person.getPassword());
			rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getInt("person_id") > 0) {
					isRegistered = true;
				}
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}

		return isRegistered;
	}
}

}
