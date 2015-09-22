package CaseStudy1;
/*
 * @author Nidhi
 * Date: 21 september 2015
 * Description: created for XML file parsing purpose
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class xmlReader
{	
	private static final String ROW = "row";
	private static final String TYPE = "type";
	private static final String VEHICLE_NO = "vehicle_no";
	
	private static final String MAKE = "make";
	private static final String MODEL = "model";
	private static final String ENGINEIN_CC = "engineIn_CC";
	private static final String FUEL_CAPACITY = "fuel_capacity";
	private static final String MILAGE = "milage";
	private static final String PRICE = "price";
	private static final String ROAD_TAX = "road_tax";
	private  static final String CREATED_BY = "created_by";
	private static final String HELMET_PRICE = "helmet_price";
	private static final String SELF_START = "self_start";
	private static final String AC = "ac";
	private static final String POWER_STEARING ="power_stearing";
	private static final String ACCESSORY_KIT = "accessory_kit";
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> readConfig(String configFile) throws SQLException
	{
	    List<Vehicle> vehicles = new ArrayList<Vehicle>();
	    try 
	    {
	      // First, create a new XMLInputFactory
	      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	      // Setup a new eventReader
	      InputStream in = new FileInputStream(configFile);
	      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
	      // read the XML document
	      Vehicle v = null;

	      while (eventReader.hasNext()) 
	      {
		        XMLEvent event = eventReader.nextEvent();
	
		        if (event.isStartElement()) 
		        {
		        	StartElement startElement = event.asStartElement();
		                // If we have an item element, we create a new item
		           
		                  // We read the attributes from this tag and add the date
		                  // attribute to our object
		               
			        
			          // If we have an item element, we create a new item
			          if (startElement.getName().getLocalPart() == (ROW))
			          {
				            // We read the attributes from this tag and add the date
				            // attribute to our object
				            Iterator<Attribute> attributes = startElement.getAttributes();
				            while (attributes.hasNext())
				            {
					              Attribute attribute = attributes.next();
					              if (attribute.getName().toString().equals(TYPE)) 
					              {
					               		if(attribute.getValue().equalsIgnoreCase("Bike"))
			               				{
					               			v = new Bike();
						               		
				               			}
					               		else if(attribute.getValue().equalsIgnoreCase("Car"))
					               		{
					               			v = new Car();
						               		 
						               	}		
					              }
				            }
			          }
			         
			          if (event.isStartElement())
			          {
			              if (event.asStartElement().getName().getLocalPart()
			                  .equals(VEHICLE_NO)) 
			              {
			                event = eventReader.nextEvent();
			              
			               v.setVehicleNo(Integer.parseInt(event.asCharacters().getData()));
			                continue;
			              }
			           }
			          
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(SELF_START)) 
			          {
			                event = eventReader.nextEvent();
			                ((Bike) v).setSelfStart((event.asCharacters().getData()));
			      
			                continue;
			              }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(HELMET_PRICE)) 
			          {
			                event = eventReader.nextEvent();
			                ((Bike) v).setHelmetPrice(Integer.parseInt(event.asCharacters().getData()));
			             
			                continue;
			          }
			          if(v instanceof Car)
			          {
				          if (event.asStartElement().getName().getLocalPart()
				                  .equals(AC))
				          {
				                event = eventReader.nextEvent();
				                ((Car) v).setAC((event.asCharacters().getData()));
				       
				                continue;
			             }
				         if (event.asStartElement().getName().getLocalPart()
			                  .equals(POWER_STEARING)) 
				         {
			                event = eventReader.nextEvent();
			                ((Car) v).setPowerStearing((event.asCharacters().getData()));
			       
			                continue;
			              }
				          if (event.asStartElement().getName().getLocalPart()
				                  .equals(ACCESSORY_KIT))
				          {
				                event = eventReader.nextEvent();
				                ((Car) v).setAccessoryKit((event.asCharacters().getData()));
				           
				                continue;
				          }
			          }
			         
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(MAKE))
			          {
			                event = eventReader.nextEvent();
			               v.setMake(Integer.parseInt(event.asCharacters().getData()));
			              
			                continue;
			          }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(MODEL)) 
			          {
			                event = eventReader.nextEvent();
			                v.setModel(event.asCharacters().getData());
			              
			                continue;
		              }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(ENGINEIN_CC)) 
			          {
			                event = eventReader.nextEvent();
			                v.setEngineInCC(Integer.parseInt(event.asCharacters().getData()));
			               
			                continue;
		              }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(FUEL_CAPACITY))
			          {
			                event = eventReader.nextEvent();
			                v.setFuelCapacity(Integer.parseInt(event.asCharacters().getData()));
			               
			                continue;
		              }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(MILAGE)) 
			          {
			                event = eventReader.nextEvent();
			                v.setMilage(Integer.parseInt(event.asCharacters().getData()));
			              
			                continue;
		              }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(PRICE))
			          {
			                event = eventReader.nextEvent();
			                v.setPrice(Integer.parseInt(event.asCharacters().getData()));
			              
			                continue;
		              }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(ROAD_TAX)) 
			          {
			                event = eventReader.nextEvent();
			                v.setRoadTax(Integer.parseInt(event.asCharacters().getData()));
			               
			                continue;
		              }
			          if (event.asStartElement().getName().getLocalPart()
			                  .equals(CREATED_BY)) 
			          {
			                event = eventReader.nextEvent();
			                v.setCreatedBy(event.asCharacters().getData());
			            
			                continue;
		              }
		         }
		          // System.out.print("*");
		          if (event.isEndElement())
		          {
		              EndElement endElement = event.asEndElement();
		             // System.out.print("*");
		              if (endElement.getName().getLocalPart() == (ROW)) 
		              {
		            	  //System.out.print("*");
		            	  vehicles.add(v);
		            	  HelperClass.executeQueryUsingPreparedStatement(v);
		              }
		          }
  			}
	    }
	    catch (FileNotFoundException e) 
	    {
	    	e.printStackTrace();
	    } 
	   catch (XMLStreamException e) 
	    {
	      e.printStackTrace();
	    }
	    return vehicles;
	}
}
