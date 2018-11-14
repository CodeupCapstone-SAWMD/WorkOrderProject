# CivTech SAWMD Challenge-- San Antonio Waste Management Division: Work Order & Inventory Tracking System

###### As Part of Civ Tech San Antonio's initiative to support public agencies, our group focused on a problem set posed by the Solid Waste Management Department (SWMD): Waste management is one of the most pressing needs within a rapidly growing city, and as San Antonio’s population on the rise, the Solid Waste Management Department (SWMD) needs an agile, responsive system to appropriately manage those services. The SWMD currently has over 1 million different sized carts in circulation, and services more than 350,000 households within the San Antonio area. Currently, SWMD operates on a paper-based data tracking system, and the City is eager to see a solution that has the latitude to revamp SWMD’s warehouse operations in three distinct areas: inventory management, work order management, and customer communication.

## Project Goals

#### Priorities
* Key focus
    - [ ] Develop an interactive form to submit and track work orders
    - [ ] Transition from a paper based inventory tracking system to a web based data tracking system for garbage carts.
    - [ ] Develop an interactive customer portal that displays the current users inventory of garbage carts and request forms to cancel or create additional garbage cart orders.

## APIs
#### Google Maps
  * Purpose:
    - Ability to tie in map based upon work order address
  * Documentation:
    - https://developers.google.com/maps/documentation/
  *Implemented:
  - [x] Appears on `Work Order Show` Page

#### Twilio
  * Purpose:
    - Ability to send out email/ text notification to customers that have requested a work order (once complete)
  * Documentation:
    - https://www.twilio.com/docs/
  *Implemented:
    - [ ] Text alert on work order status change
    - [ ] Email alert on work order status change

## Features List

##### General
* Home Page/ "Splash"
    - [x] `Registration` Button --> form
    - [x] `Login`/ Logout Buttons --> form
    - [ ] `About` Button
    - [ ] `Contact` Button
    - [ ]  Styling
    - [ ]  Imagery/ logos

* About Page
    - [ ] `Links to SAWMD webpage

* Contact Page
    - [ ] Links to SAWMD webpage
    - [ ] SAWMD contact information

*  From the `Register` button..._
  - [ ] Fields for Username, Password, First/Last name, zip, phone, profile picture, etc...
  - [ ] Checks for existing usernames/emails to avoid duplication
  - [x] Redirects to login once registered

*  Redirects
  - [ ] Logout Page
  - [ ] Errors identified, user redirected and provided with instruction
  
###### The experience now branches off into three directions, depending on the user role assigned:

#### Customers
  * Registration/ Create Profile
    - [x] Fields for pertinent information (contact information, address)
    - [ ] ~Sends email verification after submitting registration form~
    - [ ] Forwards to `Profile` page
  * Login/ Profile Redirect
    - [x] `Username` and `Password`
    - [x] Verifies username exists
    - [x] Verifies password matches
    - [x] Forwards to `Profile`
  * Edit Profile
    - [ ] Update personal info (contact information, address)
  * Work Order Dashboard
    - [x] Draft a work order request and submit to the City of San Antonio WMD
    - [x] Can see their own submitted work orders and respective status
    - [ ] View work order details
    - [ ] Receive email updates from SAWMD
    - [ ] View Work Order details

#### Employees
  * Registration/ Create Profile
    - [x] Fields for pertinent information (contact information, address)
    - [ ] ~Sends email verification after submitting registration form~
    - [ ] Forwards to `Profile` page
  * Login/ Profile Redirect
    - [x] `Username` and `Password`
    - [x] Verifies username exists
    - [x] Verifies password matches
    - [x] Forwards to `Profile`
  * Edit Profile
    - [x] Update profile info 
  * Profile/ Work Order Dashboard
    - [ ] Draft/ generate and submit a work order request on behalf of customer (perhaps using info from a phone request)
    - [x] Ability to review assigned work orders
    - [ ] Vew work order details
    - [x] Monitor the status of their submitted work orders via customer portal/ profile
    - [x] update status of assigned work order
    - [ ] upon updating status, work order forwarded for review in admin profile
    - [x] Can create/ edit see comments attached to work order
 
* * *
## Supervisors/ application administrators
#### Administrators
  * Registration/ Create Profile
    - [x] Fields for pertinent information (contact information, address)
    - [ ] Sends email verification after submitting registration form
    - [ ] Forwards to `Profile` page
  * Login/ Profile Redirect
    - [x] `Username` and `Password`
    - [x] Verifies username exists
    - [x] Verifies password matches
    - [x] Forwards to `Profile`
  * Edit Profile
    - [x] Update user profile info 
  * Profile/ Work Order Dashboard
    - [x] Ability to review assigned work orders
    - [x] Monitor the status of their submitted work orders via customer portal/ profile
    - [x] update status of assigned work order
    - [ ] Vew work order details
    - [ ] upon updating status, work order forwarded for review in admin profile
    - [x] Can create/ edit see comments attached to work order
  
## Key Administrative Functions
#### Administrators
  * Application Profile Management Privileges
    - [ ] View all users and user information
    - [ ] Assign & edit privileges to other users

  * Inventory management
    - [x] Ability to manually update inventory quantity of bins
    - [ ] Add/ Edit/ Delete inventory items (bins)
    - [x] Monitor the status of their submitted work orders via admin portal/ profile page
    - [x] update status of assigned work order
    - [ ] upon updating status, work order forwarded for review in admin profile
    - [x] Can create/ edit see comments attached to work order
    - [ ] Update / modify work order
    - [ ] Assign work orders to Employees
    - [ ] Review and complete/ cancel work orders
    - [ ] Processing of work orders automatically increments/ decrements the inventory table 


* * *
## Administrative
#### ~Admin~
* License
  - This project is licensed under the MIT License - see the LICENSE.md file for details

* Authors
  - Alois Renggli
  - Ryan Schmid
  - Ryan Stewart
  - James Young

* Built With: 
  - Bootstrap - web framework
  - Maven - Dependency Management
  - Apache Tomcat server
  - Spring w/ Thymeleaf (Java framework)

* Acknowledgements:
This is a capstone project as part of Codeup software development training program and in collaboration with CivTech SA;
Special thanks to Codeup staff and instructors, most notably Fernando Mendoza & Daniel Fryar, for their guidance and assistance.
Also, shoutout to open source software for great resources available to developers everywhere