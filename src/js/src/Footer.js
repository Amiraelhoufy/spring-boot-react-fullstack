import React from "react";
import Container from "./Container";
import { Avatar, Button } from "antd";
import './Footer.css';

const Footer = (props)=>
(
    <div className='footer'>
        <Container>
            {props.numberOfStudents !==undefined?
             <Avatar 
             style={{backgroundColor:'#f56a00', marginRight:'5px'}}
             size='large'>{props.numberOfStudents}</Avatar>: null
            }
            {/* 
            onClick = {() => props.handleAddStudentClickEvent()}  
            this approach works, it creates a new function every time the component re-renders
            */}

            {/* while using onClick= {props.handleAddStudentClickEvent}
            This approach is more efficient because it directly assigns the function as the event handler 
            */}
            
            <Button onClick= {props.handleAddStudentClickEvent} type='primary'>Add New Student +</Button>
        </Container>
    </div>
);

export default Footer;