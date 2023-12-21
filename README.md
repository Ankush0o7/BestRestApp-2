# Book Model Class

The `Book` class represents a basic model for book objects. It contains attributes such as `id`, `name`, `author`, `price`, and `genre`, providing a structure to store and manage book-related information.

## Purpose

This class serves as a blueprint for creating book objects within an application. It encapsulates properties commonly associated with books, allowing for easy manipulation, storage, and retrieval of book details.

### Attributes

- `id`: Unique identifier for the book.
- `name`: Name/title of the book.
- `author`: Author of the book.
- `price`: Price of the book.
- `genre`: Genre/category of the book.

## Usage

#### Creating a Book Object

To create a `Book` object, utilize the constructor by providing values for `id`, `name`, `author`, `price`, and `genre`.

```java
Book book = new Book(1, "Sample Book", "Sample Author", 29.99, "Sample Genre");

#### Displaying a Book Information
Utilize the toString() method to get a string representation of the Book object.
