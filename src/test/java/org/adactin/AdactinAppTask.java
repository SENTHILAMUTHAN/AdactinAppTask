package org.adactin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinAppTask {
	
public static void main(String[] args) {
	
	WebDriverManager.edgedriver().setup();
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://adactinhotelapp.com/");
	System.out.println("cloning trial 2");

//LOGIN	
	
	driver.findElement(By.id("username")).sendKeys("VIGNESHVICKY6");
	
	driver.findElement(By.id("password")).sendKeys("Adactin@123");
	
	driver.findElement(By.id("login")).click();
	
	
//SEARCH HOTEL
	//1.location
	Select s1 = new Select(driver.findElement(By.id("location")));
	
	List<WebElement> locationOptions = s1.getOptions();
	
	for (int i = 0; i < locationOptions.size(); i++) {
		WebElement locationElement = locationOptions.get(i);
		String locationText = locationElement.getText();
		if (locationText.contains("Paris")) {
			s1.selectByIndex(i);
			WebElement firstSelectedOption = s1.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//2.hotels
	Select s2= new Select(driver.findElement(By.id("hotels")));

	List<WebElement> hotelOptions = s2.getOptions();
	
	for (int i = 0; i < hotelOptions.size(); i++) {
		WebElement hotelElement = hotelOptions.get(i);
		String hotelName = hotelElement.getText();
		if (hotelName.contains("Sunshine")) {
			s2.selectByIndex(i);
			WebElement firstSelectedOption = s2.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//3.room type
	Select s3 = new Select(driver.findElement(By.id("room_type")));

	List<WebElement> roomOptions = s3.getOptions();
	
	for (int i = 0; i < roomOptions.size(); i++) {
		WebElement roomElement = roomOptions.get(i);
		String roomType = roomElement.getText();
		if (roomType.contains("Super Deluxe")) {
			s3.selectByIndex(i);
			WebElement firstSelectedOption = s3.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//4.no of rooms
	Select s4 = new Select(driver.findElement(By.id("room_nos")));
	
	List<WebElement> noOfRoomOptions = s4.getOptions();
	
	for (int i = 0; i < noOfRoomOptions.size(); i++) {
		WebElement noOfRoomElement = noOfRoomOptions.get(i);
		String noOfRooms = noOfRoomElement.getText();
		if (noOfRooms.contains("Five")) {
			s4.selectByIndex(i);
			WebElement firstSelectedOption = s4.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//5.Check In Date
	
	driver.findElement(By.name("datepick_in")).sendKeys("27/04/2024");
	
	System.out.println(driver.findElement(By.name("datepick_in")).getAttribute("value"));
	
	//6.Check Out Date
	
	driver.findElement(By.name("datepick_out")).sendKeys("29/04/2024");
	
	System.out.println(driver.findElement(By.name("datepick_out")).getAttribute("value"));
	
	//7.Adults per Room
	Select s5 = new Select(driver.findElement(By.id("adult_room")));

	List<WebElement> noOfAdultsOptions = s5.getOptions();
	
	for (int i = 0; i < noOfAdultsOptions.size(); i++) {
		WebElement noOfAdultsElement = noOfAdultsOptions.get(i);
		String noOfAdults = noOfAdultsElement.getText();
		if (noOfAdults.contains("Two")) {
			s5.selectByIndex(i);
			WebElement firstSelectedOption = s5.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//8.Children per Room
	Select s6 = new Select(driver.findElement(By.id("child_room")));

	List<WebElement> noOfChildrenOptions = s6.getOptions();
	
	for (int i = 0; i < noOfChildrenOptions.size(); i++) {
		WebElement noOfChildrenElement = noOfChildrenOptions.get(i);
		String noOfChildren = noOfChildrenElement.getText();
		if (noOfChildren.contains("None")) {
			s6.selectByIndex(i);
			WebElement firstSelectedOption = s6.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//9.search button
	driver.findElement(By.id("Submit")).click();
	
	System.out.println("\nVALUES CHECKED DURING SELECT HOTELS PAGE:- \n");
//SELECT HOTEL
	String hotelNameEntered = driver.findElement(By.id("hotel_name_0")).getAttribute("value");
	System.out.println(hotelNameEntered);
	String locationEntered = driver.findElement(By.id("location_0")).getAttribute("value");
	System.out.println(locationEntered);
	String roomEntered = driver.findElement(By.id("rooms_0")).getAttribute("value");
	System.out.println(roomEntered);
	String arrDateEntered = driver.findElement(By.id("arr_date_0")).getAttribute("value");
	System.out.println(arrDateEntered);
	String depDateEntered = driver.findElement(By.id("dep_date_0")).getAttribute("value");
	System.out.println(depDateEntered);
	String noOfDaysEntered = driver.findElement(By.id("no_days_0")).getAttribute("value");
	System.out.println(noOfDaysEntered);
	String roomTypeEntered = driver.findElement(By.id("room_type_0")).getAttribute("value");
	System.out.println(roomTypeEntered);
	String pricePerNight = driver.findElement(By.id("price_night_0")).getAttribute("value");
	System.out.println(pricePerNight);
	String totalPrice = driver.findElement(By.id("total_price_0")).getAttribute("value");
	System.out.println(totalPrice);
	driver.findElement(By.id("radiobutton_0")).click();
	driver.findElement(By.id("continue")).click();
	
	System.out.println("\nVALUES OF TEXTBOX IN BOOK A HOTEL PAGE:- \n");
//BOOK A HOTEL 
	
	String hotelNameFinal = driver.findElement(By.id("hotel_name_dis")).getAttribute("value");
	System.out.println(hotelNameFinal);
	String locationFinal = driver.findElement(By.id("location_dis")).getAttribute("value");
	System.out.println(locationFinal);
	String roomFinal = driver.findElement(By.id("room_num_dis")).getAttribute("value");
	System.out.println(roomFinal);
	String roomTypeFinal = driver.findElement(By.id("room_type_dis")).getAttribute("value");
	System.out.println(roomTypeFinal);
	driver.findElement(By.id("first_name")).sendKeys("VIGNESHWARAN");
	System.out.println(driver.findElement(By.id("first_name")).getAttribute("value"));
	driver.findElement(By.id("last_name")).sendKeys("K");
	System.out.println(driver.findElement(By.id("last_name")).getAttribute("value"));
	driver.findElement(By.id("address")).sendKeys("Choolaimedu,chennai-600094");
	System.out.println(driver.findElement(By.id("address")).getAttribute("value"));
	driver.findElement(By.id("cc_num")).sendKeys("0000111122223333");
	System.out.println(driver.findElement(By.id("cc_num")).getAttribute("value"));
	//card type
	Select s7 = new Select(driver.findElement(By.id("cc_type")));

	List<WebElement> cardTypeOptions = s7.getOptions();
	
	for (int i = 0; i < cardTypeOptions.size(); i++) {
		WebElement cardElement = cardTypeOptions.get(i);
		String cardType = cardElement.getText();
		if (cardType.contains("VISA")) {
			s7.selectByIndex(i);
			WebElement firstSelectedOption = s7.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//expiry month
	Select s8 = new Select(driver.findElement(By.id("cc_exp_month")));

	List<WebElement> expiryMonthOptions = s8.getOptions();
	
	for (int i = 0; i < expiryMonthOptions.size(); i++) {
		WebElement expiryMonthElement = expiryMonthOptions.get(i);
		String expiryMonth = expiryMonthElement.getText();
		if (expiryMonth.contains("June")) {
			s8.selectByIndex(i);
			WebElement firstSelectedOption = s8.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	//expiry year
	Select s9 = new Select(driver.findElement(By.id("cc_exp_year")));

	List<WebElement> expiryYearOptions = s9.getOptions();
	
	for (int i = 0; i < expiryYearOptions.size(); i++) {
		WebElement expiryYearElement = expiryYearOptions.get(i);
		String expiryYear = expiryYearElement.getText();
		if (expiryYear.contains("2030")) {
			s9.selectByIndex(i);
			WebElement firstSelectedOption = s9.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			break;
		}
	}
	driver.findElement(By.id("cc_cvv")).sendKeys("0123");
	System.out.println(driver.findElement(By.id("cc_cvv")).getAttribute("values"));
	driver.findElement(By.id("book_now")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//BOOKING CONFIRMATION
	System.out.println("\nVALUES VERIFICATION AT BOOKING CONFIRMATION PAGE:- \n");
	System.out.println(driver.findElement(By.id("hotel_name")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("location")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("room_type")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("arrival_date")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("departure_text")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("total_rooms")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("adults_room")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("children_room")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("price_night")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("total_price")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("gst")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("final_price")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("first_name")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("last_name")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("address")).getAttribute("value"));
	String orderNo = driver.findElement(By.id("order_no")).getAttribute("value");
	System.out.println(orderNo);
	driver.findElement(By.id("my_itinerary")).click();
//Booked Itinerary
	
	System.out.println("\nATTRIBUTE VALUE OF TEXT BOX:- \n");
	
	WebElement table = driver.findElement(By.xpath("//table[@cellspacing='1']"));
	
	List<WebElement> rowElements = table.findElements(By.tagName("tr"));
	
	
	for (int i = 0; i < rowElements.size(); i++) {
		
		if (i!=rowElements.size()-1) {
			continue;
		}
		
		WebElement webElement = rowElements.get(i);
		
		List<WebElement> findElements = webElement.findElements(By.xpath("//input[@type='checkbox']"));
		
		for (int j = 1; j < findElements.size(); j++) {
			
			if (j!=findElements.size()-1) {
				
				findElements.get(j).click();
				continue;
			}
			driver.findElement(By.name("cancelall")).click();
		    
		}
	}
	driver.switchTo().alert().accept();
	
	List<WebElement> list = driver.findElements(By.xpath("//input[@class='select_text']"));
	
	for (int i = 0; i < list.size(); i++) {
		WebElement element = list.get(i);
		
		System.out.println(element.getAttribute("value"));
	}
	driver.findElement(By.id("logout")).click();
	String logOut = driver.findElement(By.xpath("//td[@class='reg_success']")).getText();
	System.out.println(logOut);
}
}

