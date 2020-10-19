package telran.utils;

import java.time.LocalDate;

import telran.persons.dto.Address;

public class RandomData {
	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	public static long getRandomLong(long min, long max) {
		return (long) (min + Math.random() * (max - min + 1));

	}

	public static <T> T getRandomElement(T[] array) {
		int index = getRandomInt(0, array.length - 1);
		return array[index];
	}

	public static int getRandomChance() {
		return getRandomInt(1, 100);
	}

	public static String getRandomName() {
		String[] names = { "Yehudi Mannes", "Johan Spitzer", "Yoel Myer", "Adin Gollancz", "Cain Berlin",
				"Benzion Sarlin", "Avidan Weidenseld", "Adon Yoffey", "Moshe Mazar", "Hyman Grois", "Anat Meir",
				"Lior Herzl", "Ofra Berlin", "Ya'el Reiss", "Hodaya Yakobovitch", "Noga Pollack", "Noga Sharett",
				"Drorit Garbacz", "Eina Angel", "Nitzana Schapiro", "Lewi Krausz", "Yered Dayan", "Shimshon Weizmann",
				"Absolom Pirbright", "Adin Eshkol", "Lemuel Shulman", "Aitan Spiro", "Machum Stiebel", "Lev Blum",
				"Azriel Maxse", "Galina Yoffey", "Hannah Levenberg", "Orah Kahan", "Kalanit Gluckstein", "Roza Borach",
				"Shoshi Mankowitz", "Chedva Trachtenberg", "Avior Hirst", "Yonat Sharansky", "Nurit Sarasohn" };
		int index = getRandomInt(0, names.length - 1);
		return names[index];
	}

	public static LocalDate getRandomDate(int minYear, int maxYear) {
		return LocalDate.of(getRandomInt(minYear, maxYear), getRandomInt(1, 12), getRandomInt(1, 28));
	}

	public static Address getRandomAddress() {
		String city = getRandomCity();
		String street = getRandomStreet();
		int aprt = getRandomInt(1, 400);
		int building = getRandomInt(1, 600);
		return new Address(city, street, aprt,building);
	}

	private static String getRandomStreet() {
		String[] streets = { "Myrtle", "Wayridge", "Kenwood", "Lerdahl", "Bartelt", "Westerfield", "Almo", "Drewry",
				"Manufacturers", "Independence", "Bayside", "Golf", "Manufacturers", "Shoshone", "Burning Wood",
				"Hollow Ridge", "Del Sol", "Washington", "Tennyson", "Arkansas", "David", "Columbus", "Iowa",
				"Northland", "North", "West", "Union", "Jay", "Laurel", "Gale", "Garrison", "Chinook", "Mallard",
				"Kinsman", "La Follette", "Barby", "Burrows", "Bartillon", "Holy Cross", "Monument", "Cambridge",
				"Springs", "Thierer", "Loeprich", "Iowa", "Farmco", "Homewood", "Crownhardt", "Washington", "Bartelt",
				"Haas", "Susan", "Carberry", "Del Mar", "Huxley", "Kipling", "Scott", "Dayton", "Hintze", "Northland",
				"School", "Summit", "Riverside", "6th", "Huxley", "Dottie", "Division", "Bunker Hill", "Killdeer",
				"Westport", "Norway Maple", "Monica", "Transport", "International", "Monument", "Sheridan", "Mesta",
				"Sachs", "Maple Wood", "Sundown", "Paget", "Heffernan", "Badeau", "Nobel", "Scott", "Randy", "Prentice",
				"Elmside", "Jay", "Dahle", "Manitowish", "Manitowish", "Anzinger", "Center", "Pearson", "Schlimgen",
				"Haas", "Vermont", "Porter", "Hanover" };

		return getRandomElement(streets);
	}

	private static String getRandomCity() {
		String[] citys = { "Afula", "Akko", "Arad", "Ariel", "Ashdod", "Ashkelon", "Baqa al-Gharbiyye", "Bat Yam",
				"Beer Sheva", "Beit Shean", "Beit Shemesh", "Betar Illit", "Bnei Berak", "Dimona", "Eilat", "Elad",
				"Givatayim", "Hadera", "Haifa", "Harish", "Herzliya", "Hod HaSharon", "Holon", "Jerusalem", "Karmiel",
				"Kfar Sava", "Kiryat Ata", "Kiryat Bialik", "Kiryat Gat", "Kiryat Malachi", "Kiryat Motzkin",
				"Kiryat Ono", "Kiryat Shemone", "Kiryat Yam", "Lod", "Maale Adumim", "Maalot Tarshiha", "Migdal HaEmek",
				"Modiin", "Nahariya", "Nazareth", "Nes Ziona", "Nesher", "Netanya", "Netivot", "Nof Hagalil", "Ofakim",
				"Or Akiva", "Or Yehuda", "Petah Tikva", "Qalansawe", "Raanana", "Rahat", "Ramat Hasharon", "Ramat-Gan",
				"Ramla", "Rehovot", "Rishon Lezion", "Rosh Ha'ayin", "Sakhnin", "Sderot", "Shefaram", "Taibeh", "Tamra",
				"Tel Aviv", "Tiberias", "Tira", "Tirat Carmel", "Tsfat (Safed)", "Umm al-Fahm", "Yavne",
				"Yehud-Monosson", "Yokneam" };

		return getRandomElement(citys);
	}

	public static String getRandomCompany() {
		String[] companys = { "AudioCodes", "BG Robotics", "MorphiSec", "SourceDefence",
				"IAI (only the commercial side)", "Augury", "Driveway Software", "Philips", "Ciphersip",
				"Generel Electrics", "Apple", "Appsflyer", "General Motors", "Jacada", "MS Tech", "Papaya Global",
				"Playtika", "Verint", "Neuroblade", "40 Nuggets", "Agat Software", "AutoLeadstar", "cnvrg.io", "DDS",
				"Ericom", "Ex-Libris", "Freightos", "Gamatronic", "GradTrain", "Hometalk", "Intel",
				"Kahena Digital Marketing", "L&T Technology Services", "Lightricks", "Medtronic", "Mobileye", "Neteera",
				"Ophir", "Orcam", "Quickode", "Revelator", "Sephira", "Sintec Media", "Smartibus",
				"Synamedia (formerly Cisco)", "TocNdix", "Verisense", "Vernet Technologies", "Vinci Works", "VLX",
				"Wisestamp", "Brix", "Next Insurance", "Imubit", "TandemG", "ebay", "Jfrog", "Qualitest",
				"Bezeq International", "Cellebrite", "Citibank Israel", "ClickSoftware", "cloudinary", "Cyberark",
				"ECI", "Glassdox", "Payoneer", "QualiTest Group", "Amdocs", "Beyond Security", "CyberBit", "Drivenets",
				"Komodo Consulting", "NICE", "TravelFactory", "Sela", "Checkmarx", "Kaltura", "sqlink", "Time To Know",
				"Applied Materials", "Cynet", "AllCloud", "Waterfall Security", "Akamai", "Aspectiva", "binah.ai",
				"Booking.Com", "Camilyo", "Cato Networks", "Ceragon Networks",
				"Check Point Software  Technologies Israel Office", "CITIBANK (R&D)", "Cornerstone OnDemand",
				"Cybereason", "Dagshub", "Datorama", "Deloitte", "Develeaps", "DSP Group", "Duda", "E-Toro",
				"Elad systems", "Ensilo", "Evya", "Explorium", "Fiverr", "Forter", "Google", "Healthy.IO", "Houzz",
				"IBM", "ICE", "Imperva", "Intuit", "Investing.com", "ironSource", "Lemonade", "Lightico", "Logz.io",
				"Matrix", "Melio", "Modelity", "Monday.com", "Moonactive", "MyHeritage", "Natural Intelligence", "Ness",
				"Nova Measuring Instruments LTD", "Playtika", "RAD", "Radwin", "RealCommerce", "Redis Labs",
				"Riskified", "Sellerops", "SimilarWeb", "Sisense", "Softwheel", "Spot.IM", "Team 8", "Trax Retail",
				"Tufin", "Vonage", "WalkMe", "Web Pals Ltd", "WeWork", "Wix", "Amazon", "Amazon Annapurna", "Mellanox",
				"Viber", "Vulcan Cyber", "Breach Digital", "Red Hat", "Seebo", "Signals Analytics", "Tag VS" };
		return getRandomElement(companys);
	}
	public static String getRandomGarden() {
		String[] garden = { "A0", "A1", "B1", "B2" };
		return getRandomElement(garden);
	}

	public static String getRandomTitle() {
		String[] titles = { "QA tester", "Development Programmer", "Development Manager", "QA Manager" };
		return getRandomElement(titles);
	}
}
