package resources;

import java.util.ArrayList;
import java.util.List;

import com.Pojo.AddPlace;
import com.Pojo.Location;

public class TestDataPayload {
	
	public AddPlace addPlacePayload(String name, String language,String address) 
	{
		AddPlace ap = new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");

		// build the list and pass the list to the "setTypes Method"..
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ap.setTypes(myList);

		// Create an object of Location class and pass the location object to "Location
		// Set Methods".
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		ap.setLocation(l);
		
		return ap;
	}

}
