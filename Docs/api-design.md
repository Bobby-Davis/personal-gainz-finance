# API Design -PersonalGainz Finance App

This document defines the backend API for the PersonalGainz Finance App.


---

## 1. Overview

- Style: **REST API**
- Data format: **JSON**
- Base URL (local dev): `http://localhost:8080`
- All endpoints start with: `/api/...`
- Authentication: **JWT (JSON Web Token)**
    - Public (no token required): `/api/auth/register`, `/api/auth/login`
    - All other `/api/**` endpoints require a valid JWT token in the `Authorization` header:

    `Authorization: Bearer <token>`
---

## 2. Data Models

These are the core objects the backend will manage

### 2.1 User
- id: number - unique user ID
- email: string - user's login email
- passwordHash: string - hashed password (never returned in responses)
- createdAt: datetime

### 2.2 Bill
- id: number - Unique bill ID
- userId: number - ID of the user who owns the bills
- name: string - name of the bill (Electric, Rent, etc..)
- amount: number - amount due
- dueDate: date - next due date
- category: string - Utilities, Housing, Subscription, etc...
- autoPay: boolean - whether the bill is set to auto-pay
- paid: boolean - whether the current cycle is marked paid
- notes: string - optional notes
- createdAt: datetime
- updatedAt: datetime

---

## 3. Endpoints

### POST /api/auth/register
Registers a new user.

Request:
```json
{
    "email": "test@example.com",
    "password": "Mypassword123"
}
```
Success Response:
```json
{
    "message": "User created successfully"
}
```

Error Response:
```json
{
    "error": "Email is already registered"
}
```

### POST /api/auth/login
Logs in a user and returns a JWT token
Request:
```json
{
    "email": "test@example",
    "password": "Mypassword123"
}
```

Success Response:
```json
{
    "token": "jwt-token-value-here"
}
```

Error Response:
```json
{
    "error": "Invalid email or password"
}
```

### GET /api/bills
Returns all bills for the authenticated user

Sucess Response:
```json
[
    {
        "id": 1,
        "name": "Electric Bill",
        "amount": 120.50,
        "dueDate": "2025-11-15",
        "category": "Utilties",
        "autoPay": false,
        "paid": false,
        "notes": "",
        "createdAt": "2025-11-01T12:34:56",
        "updatedAt": "2025-11-01T12:34:56"
    }
]
```

### POST /api/bills
Creates a new bill

Request:
```json
{
  "name": "Rent",
  "amount": 1500.00,
  "dueDate": "2025-12-01",
  "category": "Housing",
  "autoPay": false,
  "notes": "Pay online"
}
```


Success Response:
```json
{
  "id": 2,
  "name": "Rent",
  "amount": 1500.00,
  "dueDate": "2025-12-01",
  "category": "Housing",
  "autoPay": false,
  "paid": false,
  "notes": "Pay online",
  "createdAt": "2025-11-01T13:00:00",
  "updatedAt": "2025-11-01T13:00:00"
}
```

### GET /api/bills/{id}
Returns a single bill belonging to the user

Success Response:
```json
{
  "id": 2,
  "name": "Rent",
  "amount": 1500.00,
  "dueDate": "2025-12-01",
  "category": "Housing",
  "autoPay": false,
  "paid": false,
  "notes": "Pay online",
  "createdAt": "2025-11-01T13:00:00",
  "updatedAt": "2025-11-01T13:00:00"
}
```

Error Response:
```json
{
  "error": "Bill not found"
}
```


### PUT /api/bills/{id}
Updates an existing bill.

Request:
```json
{
  "name": "Updated Rent",
  "amount": 1550.00,
  "dueDate": "2025-12-01",
  "category": "Housing",
  "autoPay": true,
  "notes": "On auto-pay"
}
```

Success Response:
```json
{
  "id": 2,
  "name": "Updated Rent",
  "amount": 1550.00,
  "dueDate": "2025-12-01",
  "category": "Housing",
  "autoPay": true,
  "paid": false,
  "notes": "On auto-pay",
  "createdAt": "2025-11-01T13:00:00",
  "updatedAt": "2025-11-05T09:30:00"
}
```

### DELETE /api/bills/{id}
Deletes a bill

Success Response: (204 No Content)
(no body)

Error Response:
```json
{
  "error": "Bill not found"
}
```

### PUT /api/bills/{id}/pay
Marks the bill as paid

Success Response:
```json
{
  "id": 2,
  "paid": true
}
```

## 4. Error Format
All errors follow:
```json
{
  "error": "Message describing the problem"
}
```