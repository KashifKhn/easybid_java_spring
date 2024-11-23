### **Endpoint List**

#### **Authentication**

- `POST /api/v1/auth/register`: Register a new user.
- `POST /api/v1/auth/login`: Authenticate and issue JWT.
- `POST /api/v1/auth/logout`: Logout user.
- `POST /api/v1/auth/refresh`: Refresh JWT token.

#### **User Management**

- `GET /api/v1/users/me`: Fetch current user details.
- `PUT /api/v1/users/me`: Update user profile.
- `DELETE /api/v1/users/me`: Delete user account.

#### **Item Endpoints**

- `POST /api/v1/items`: Create a new item.
- `GET /api/v1/items`: List all items (with filters and pagination).
- `GET /api/v1/items/{item_id}`: Get item details.
- `PUT /api/v1/items/{item_id}`: Update an item.
- `DELETE /api/v1/items/{item_id}`: Delete an item.

#### **Auction Endpoints**

- `POST /api/v1/auctions`: Start a new auction.
- `GET /api/v1/auctions`: List auctions (with filters and pagination).
- `GET /api/v1/auctions/{auction_id}`: Get auction details.
- `PATCH /api/v1/auctions/{auction_id}/status`: Update auction status.
- `DELETE /api/v1/auctions/{auction_id}`: Cancel an auction.

#### **Bid Endpoints**

- `POST /api/v1/bids`: Place a bid.
- `GET /api/v1/bids`: List bids (e.g., `?auction_id=...`).

#### **Payment Endpoints**

- `POST /api/v1/payments`: Create a new payment.
- `GET /api/v1/payments/{payment_id}`: Get payment details.

#### **Review Endpoints**

- `POST /api/v1/reviews`: Submit a review.
- `GET /api/v1/reviews`: List reviews for a user (e.g., `?user_id=...`).

#### **Notification Endpoints**

- `GET /api/v1/notifications`: List all notifications for a user.
- `PUT /api/v1/notifications/{notification_id}`: Mark as read.
- `DELETE /api/v1/notifications/{notification_id}`: Delete a notification.

#### **Admin Endpoints**

- `GET /api/v1/admin/users`: Manage users.
- `GET /api/v1/admin/reports`: View platform reports.
- `POST /api/v1/admin/items/{item_id}/actions`: Approve, reject, or flag items.
