### **Endpoint List**

#### **Authentication**

- `POST /v1/api/auth/register`: Register a new user.
- `POST /v1/api/auth/login`: Authenticate and issue JWT.
- `POST /v1/api/auth/logout`: Logout user.
- `POST /v1/api/auth/refresh`: Refresh JWT token.

#### **User Management**

- `GET /v1/api/users/me`: Fetch current user details.
- `PUT /v1/api/users/me`: Update user profile.
- `DELETE /v1/api/users/me`: Delete user account.

#### **Item Endpoints**

- `POST /v1/api/items`: Create a new item.
- `GET /v1/api/items`: List all items (with filters and pagination).
- `GET /v1/api/items/{item_id}`: Get item details.
- `PUT /v1/api/items/{item_id}`: Update an item.
- `DELETE /v1/api/items/{item_id}`: Delete an item.

#### **Auction Endpoints**

- `POST /v1/api/auctions`: Start a new auction.
- `GET /v1/api/auctions`: List auctions (with filters and pagination).
- `GET /v1/api/auctions/{auction_id}`: Get auction details.
- `PATCH /v1/api/auctions/{auction_id}/status`: Update auction status.
- `DELETE /v1/api/auctions/{auction_id}`: Cancel an auction.

#### **Bid Endpoints**

- `POST /v1/api/bids`: Place a bid.
- `GET /v1/api/bids`: List bids (e.g., `?auction_id=...`).

#### **Payment Endpoints**

- `POST /v1/api/payments`: Create a new payment.
- `GET /v1/api/payments/{payment_id}`: Get payment details.

#### **Review Endpoints**

- `POST /v1/api/reviews`: Submit a review.
- `GET /v1/api/reviews`: List reviews for a user (e.g., `?user_id=...`).

#### **Notification Endpoints**

- `GET /v1/api/notifications`: List all notifications for a user.
- `PUT /v1/api/notifications/{notification_id}`: Mark as read.
- `DELETE /v1/api/notifications/{notification_id}`: Delete a notification.

#### **Admin Endpoints**

- `GET /v1/api/admin/users`: Manage users.
- `GET /v1/api/admin/reports`: View platform reports.
- `POST /v1/api/admin/items/{item_id}/actions`: Approve, reject, or flag items.
