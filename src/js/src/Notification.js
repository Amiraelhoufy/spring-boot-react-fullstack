import React from 'react';
import { Button, message, notification, Space } from 'antd';

// Function to open a notification with the specified type, message, and description
   const openNotification = (type,message,description) => {
    notification[type]({
      message,    // Set the message of the notification
      description // Set the description of the notification
    });
  };

// Call the `openNotification` function with the type 'success'
export const successNotification=(status,message,description) =>{
    openNotification('success',status,description)
};

// Call the `openNotification` function with the type 'info'
export const infoNotification=(status,message,description) =>{
    openNotification('info',status,description)
};

// Call the `openNotification` function with the type 'warning'
export const warningNotification=(status,message,description) =>{
    openNotification('warning',status,description)
};

// Call the `openNotification` function with the type 'error'
export const errorNotification=(status,message,description) =>{
    openNotification('error',status,description)
    
};