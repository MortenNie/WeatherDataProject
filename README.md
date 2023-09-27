# WeatherDataProject
Hold B Gruppe 7

Morten, Jakob, Dimitra


**<h3>1. A Description of work progress:</h3>**

We decided to work every day in class like last time. <br>
We feel like we work better as a group this way.
We've used Kanban boards, Github Desktop, IntelliJ 2023.2.1. <br>
We've also used things like Discord to communicate when not together physically.



**<h3>2. Business Model:</h3>**

xD(placeholder)



**<h3>3. Picture of EER Diagram:</h3>**

xD(placeholder)






**<h3>4. Links and tools used: </h3><br>**
We've used the website https://vejr.tv2.dk/ to webscrape information from. <br>

We then used the API https://openweathermap.org/current to Enrich our information. <br>

This is the API We used: https://api.openweathermap.org/data/2.5/weather 

From the API we Enriched our Weather information with additional Weather information, including <br>
things like Longtitude, Latitude, A text description of the weather, Humidity levels and wind degrees.


<h3>Edge Cases:</h3>

Edge cases for a project like this would or could include things such as: <br>


- **Missing Data on the Website: <br>**
**Edge Case:** The website we are scraping from lacks information in certain areas or locations. <br>
**Fix:** We made it so within our Webscraping class that if there are tables with no information, or empty tables, they will be ignored.


- **Rate Limiting or IP Blocking:** <br>
**Edge Case:** The website detects a high volume of requests from our IP address and blocks or limits further access. <br>
**Potential Fix:** Our project only scrapes when we run it, so the chance of us overloading the website and getting IP blocked is very low.
However, if we had some automatic scraping system or had to scrape many times in a row, or in a loop, then adding a delay with Thread.sleep() for example would be handy
so that you don't overload the server and get yourself IP Blocked.


- **Website Downtime or Maintenance:** <br>
  **Edge Case:** The website we are scraping from is temporarily down or undergoing maintenance. <br>
  **Potential Fix:** We could put our scraping action into an If statement and loop that will continuously run until it succeeds by getting information back.
This is where a downtime/delay in the loop would be great to implement.