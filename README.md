# Spring Web MVC Lab 1

Congratulations! You have been hired by Access Camp and for your first task, you
have been tasked with building out a website to log campers with their
activities.

Your task is to build the API according to the deliverables below.

## Setup

Use [Spring Initializr](https://start.spring.io/) to create a project with the
following properties:

- Java 11
- Maven Build

And add the following dependencies:

- Spring Web.
- Spring Data JPA.
- A database of your choice (H2, Postgres, MySQL).

Generate the project and open it up in IntelliJ.

## Models

You need to create the following relationships:

- A `Camper` has many `Signups`, and has many `Activity`s through `Signup`s
- An `Activity` has many `Signups`, and has many has many `Camper`s through
  `Signup`s
- A `Signup` belongs to a `Camper` and belongs to a `Activity`

Start by creating the models and migrations for the following database tables:

![domain diagram](https://curriculum-content.s3.amazonaws.com/phase-4/mock-challenge-camping-fun/diagram.png)

## Validations

Add validations to the `Camper` model:

- must have a `name`
- must have an `age` between 8 and 18

Add validations to the `Signup` model:

- must have a `time` between 0 and 23 (referring to the hour of day for the
  activity)

## Routes

Set up the following routes. Make sure to return JSON data in the format
specified along with the appropriate HTTP verb.

### GET /campers

Return JSON data in the format below. **Note**: you should return a JSON
response in this format, without any additional nested data related to each
camper.

```json
[
  {
    "id": 1,
    "name": "Caitlin",
    "age": 8
  },
  {
    "id": 2,
    "name": "Lizzie",
    "age": 9
  }
]
```

### GET /campers/:id

If the `Camper` exists, return JSON data in the format below. 

**Note**: you will
need to serialize the data for this response differently than for the
`GET /campers` route. Make sure to include an array of activities for each
camper.

```json
{
  "id": 1,
  "name": "Caitlin",
  "age": 8,
  "activities": [
    {
      "id": 1,
      "name": "Archery",
      "difficulty": 2
    },
    {
      "id": 2,
      "name": "Swimming",
      "difficulty": 3
    }
  ]
}
```

If the `Camper` does not exist, return the following JSON data, along with the
appropriate HTTP status code:

```json
{
  "error": "Camper not found"
}
```

### POST /campers

This route should create a new `Camper`. It should accept an object with the
following properties in the body of the request:

```json
{
  "name": "Zoe",
  "age": 11
}
```

If the `Camper` is created successfully, send back a response with the new
`Camper`:

```json
{
  "id": 2,
  "name": "Zoe",
  "age": 11
}
```

If the `Camper` is **not** created successfully, return the following JSON data,
along with the appropriate HTTP status code:

```json
{
  "errors": ["validation errors"]
}
```

### GET /activities

Return JSON data in the format below:

```json
[
  {
    "id": 1,
    "name": "Archery",
    "difficulty": 2
  },
  {
    "id": 2,
    "name": "Swimming",
    "difficulty": 3
  }
]
```

### DELETE /activities/:id

If the `Activity` exists, it should be removed from the database, along with any
`Signup`s that are associated with it (a `Signup` belongs to an `Activity`, so
you need to delete the `Signup`s before the `Activity` can be deleted).

After deleting the `Activity`, return an _empty_ response body, along with the
appropriate HTTP status code.

If the `Activity` does not exist, return the following JSON data, along with the
appropriate HTTP status code:

```json
{
  "error": "Activity not found"
}
```

### POST /signups

This route should create a new `Signup` that is associated with an existing
`Camper` and `Activity`. It should accept an object with the following
properties in the body of the request:

```json
{
  "time": 9,
  "camper_id": 1,
  "activity_id": 3
}
```

If the `Signup` is created successfully, send back a response with the data
related to the `Activity`:

```json
{
  "id": 1,
  "name": "Archery",
  "difficulty": 2
}
```

If the `Signup` is **not** created successfully, return the following JSON data,
along with the appropriate HTTP status code:

```json
{
  "errors": ["validation errors"]
}
```
