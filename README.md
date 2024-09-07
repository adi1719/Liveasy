A Spring Boot application utilizing MongoDB for backend load management. Includes features for adding, retrieving, updating, and deleting load records. This API supports operations such as managing load details, querying by shipper ID, and handling individual load entries with MongoDB as the data store.

# Spring boot initializr
![image](https://github.com/user-attachments/assets/39be876a-fbc7-400c-83d8-e020d29f2cc7)

# Folder Structure
![image](https://github.com/user-attachments/assets/ec0660f8-074b-4c91-a227-17576cffd73d)

**Example GET Request by loadId:**
```bash
curl --location 'http://localhost:8080/load/66dbf4f3a232992090ba255a'
```

**Example GET Request by shipperId:**
```bash
curl --location 'http://localhost:8080/load?shipperId=shipper3'
```

**Example POST Request:**
```bash
curl --location 'http://localhost:8080/load' \
--header 'Content-Type: application/json' \
--data '{
    "loadingPoint": "Delhi",
    "unloadingPoint": "Jaipur",
    "productType": "Chemicals",
    "truckType": "Canter",
    "noOfTrucks": 1,
    "weight": 100,
    "comment": "Handle with care",
    "shipperId": "shipper1",
    "date": "2024-09-01"
}'
```

