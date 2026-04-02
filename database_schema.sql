-- 1. Users Table (For Sign Up/Sign In) [cite: 46]
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(20) DEFAULT 'USER'
);

-- 2. Hotels Table 
CREATE TABLE hotels (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    amenities TEXT,
    description TEXT
);

-- 3. Rooms Table (Linked to Hotels) [cite: 16, 60]
CREATE TABLE rooms (
    id INT PRIMARY KEY AUTO_INCREMENT,
    hotel_id INT,
    room_type VARCHAR(50), -- e.g., Deluxe, Suite
    price_per_night DECIMAL(10, 2),
    is_available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);

-- 4. Bookings Table (Links Users to Rooms) [cite: 16, 60]
CREATE TABLE bookings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    room_id INT,
    check_in_date DATE,
    check_out_date DATE,
    status VARCHAR(20) DEFAULT 'CONFIRMED', -- [cite: 43]
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);