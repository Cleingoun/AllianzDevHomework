# Allianz DevHomework

### TASK:
The homework was to create a REST API for creating and querying the CO2 data.

### How to use the API 

There are a few different methods.

1. getCO2District, which gives back the CO2 Data of a single District. 
The curl command for it is:
```
curl -X \
POST -H "Content-Type: application/json" -d \
'{"district":"Maxvorstadt"}' \
localhost:8080/api/getCO2District
```

2. getCO2City, which gives back the CO2 Data of a whole City.
The curl command for it is:
```
curl -X \
POST -H "Content-Type: application/json" -d \
'{"city":"München"}' \
localhost:8080/api/getCO2City
```

3. postCO2, is where the sensor sends its data.
The curl command for it is:
```
curl -X \
POST -H "Content-Type: application/json" -d \
'{"city":"München","district":"Maxvorstadt","timestamp":3920252,"co2Data":"Wir haben 30% CO2"}' \
localhost:8080/api/reading
```

4. createDistrict, to create a new District.
The curl command for it is:
```
curl -X \
POST -H "Content-Type: application/json" -d \
'{"district": "Maxen","city": "München"}' \
localhost:8080/api/reading
```


### How to use the H2 Database

In the File application.properties which is in "src/main/resources", you can see the correct datasource url.
<br>
To get to the H2 Interface you have to visit: [H2 DATABASE](http://localhost:8080/h2-console)