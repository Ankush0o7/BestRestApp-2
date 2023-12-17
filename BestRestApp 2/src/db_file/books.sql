-- Table structure for table `books`
CREATE TABLE `books` (
  `id` INT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL,
  `author` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  `genre` VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table `books`
INSERT INTO `books` (`id`, `name`, `author`, `price`, `genre`) VALUES
(1, 'The Great Gatsby', 'F. Scott Fitzgerald', 10.99, 'Classic'),
(2, 'To Kill a Mockingbird', 'Harper Lee', 12.99, 'Fiction'),
(3, '1984', 'George Orwell', 9.99, 'Dystopian'),
(4, 'The Hobbit', 'J.R.R. Tolkien', 15.99, 'Fantasy');

-- Indexes for table `books`
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);
