CREATE TABLE Customer(
	CustomerID UNIQUEIDENTIFIER NOT NULL,
	FirstName VARCHAR(20) NOT NULL,
	LastName VARCHAR(20) NOT NULL,
	MiddleName VARCHAR(20) NOT NULL,
	DateBirth DATE NOT NULL,
	AddressStreet VARCHAR(40) NOT NULL,
	AddressTown VARCHAR(30) NOT NULL,
	AddressCountry VARCHAR(30) NOT NULL,
	AddressZipCode VARCHAR(11) NOT NULL,
	WorkPhone VARCHAR(20) NOT NULL,
	HomePhone VARCHAR(20),
	Email VARCHAR(50),

PRIMARY KEY(CustomerID)
)

CREATE TABLE Guest(
	GuestID UNIQUEIDENTIFIER NOT NULL,
	FirstName VARCHAR(20) NOT NULL,
	LastName VARCHAR(20) NOT NULL,
	MiddleName VARCHAR(20) NOT NULL,
	DateBirth DATE NOT NULL,
	AddressStreet VARCHAR(40) NOT NULL,
	AddressTown VARCHAR(30) NOT NULL,
	AddressCountry VARCHAR(30) NOT NULL,
	AddressZipCode VARCHAR(11) NOT NULL,
	ContactPhone VARCHAR(20) NOT NULL,

PRIMARY KEY(GuestID)
)

CREATE TABLE RoomType(
	RoomTypeID UNIQUEIDENTIFIER NOT NULL,
	RoomType VARCHAR(30) NOT NULL,
	MaxCapacity TINYINT NOT NULL,

PRIMARY KEY(RoomTypeID),
)

CREATE TABLE Room(
	RoomID UNIQUEIDENTIFIER NOT NULL,
	RoomTypeID UNIQUEIDENTIFIER NOT NULL,
	Price DECIMAL(5, 2),
	Number SMALLINT NOT NULL,
	Floor SMALLINT NOT NULL,
	AdditionalNotes VARCHAR(150),

PRIMARY KEY(RoomID),
FOREIGN KEY(RoomTypeID) REFERENCES RoomType(RoomTypeID),
)

CREATE TABLE Facility(
	FacilityID UNIQUEIDENTIFIER NOT NULL,
	FacilityName VARCHAR(20) NOT NULL,

PRIMARY KEY(FacilityID),
)

CREATE TABLE RoomFacility(
	RoomID UNIQUEIDENTIFIER NOT NULL,
	FacilityID UNIQUEIDENTIFIER NOT NULL,
	FaciliteDetails VARCHAR(150),

FOREIGN KEY(RoomID) REFERENCES Room(RoomID),
FOREIGN KEY(FacilityID) REFERENCES Facility(FacilityID),
)

CREATE TABLE Booking(
	BookingID UNIQUEIDENTIFIER NOT NULL,
	CustomerID UNIQUEIDENTIFIER NOT NULL,
	DateTimeMade DATETIME NOT NULL,
	BookingComment VARCHAR(100),

PRIMARY KEY(BookingID),
FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID)
)

CREATE TABLE BookingRoom(
	BookingID UNIQUEIDENTIFIER NOT NULL,
	RoomID UNIQUEIDENTIFIER NOT NULL,
	GuestID UNIQUEIDENTIFIER NOT NULL,
	StartDate DATETIME NOT NULL,
	EndDate DATETIME NOT NULL,

FOREIGN KEY(BookingID) REFERENCES Booking(BookingID),
FOREIGN KEY(RoomID) REFERENCES Room(RoomID),
FOREIGN KEY(GuestID) REFERENCES Guest(GuestID),
)

CREATE TABLE PaymentMethod(
	PaymentMethodID UNIQUEIDENTIFIER NOT NULL,
	PaymentMethod VARCHAR(30) NOT NULL,

PRIMARY KEY(PaymentMethodID),
)

CREATE TABLE Payment(
	PaymentID UNIQUEIDENTIFIER NOT NULL,
	BookingID UNIQUEIDENTIFIER NOT NULL,
	CustomerID UNIQUEIDENTIFIER NOT NULL,
	PaymentMethodID UNIQUEIDENTIFIER NOT NULL,
	
	PaymentComment VARCHAR(100),

PRIMARY KEY(PaymentID),
FOREIGN KEY(BookingID) REFERENCES Booking(BookingID),
FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID),
FOREIGN KEY(PaymentMethodID) REFERENCES PaymentMethod(PaymentMethodID),
)

CREATE TABLE security_role(
  RoleID UNIQUEIDENTIFIER NOT NULL,
  RoleName VARCHAR(100) NOT NULL,
  PRIMARY KEY(RoleID)
)

CREATE TABLE security_user(
  UserID UNIQUEIDENTIFIER NOT NULL,
  Login VARCHAR(100) NOT NULL,
  Password VARCHAR(100) NOT NULL,
  CustomerID UNIQUEIDENTIFIER NULL,
  PRIMARY KEY(UserID),
  FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID)
)
CREATE TABLE security_userInRole (
  UserID UNIQUEIDENTIFIER NOT NULL,
  RoleID UNIQUEIDENTIFIER NOT NULL,
  FOREIGN KEY(UserID) REFERENCES security_user(UserID),
  FOREIGN KEY(RoleID) REFERENCES security_role(RoleID)
)