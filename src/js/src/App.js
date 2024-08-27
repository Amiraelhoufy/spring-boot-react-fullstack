import './App.css';
import React, { useState, useEffect } from 'react';
import { getAllStudents } from './client';
import { Container } from './Container';
import Footer from './Footer';
import Spinner from './Spinner';
import AddStudentForm from './forms/AddStudentForm';
import { errorNotification } from './Notification';

import {
  Avatar,
  Empty,
  Modal,
  Table,
  notification
} from 'antd';

function App() {
  const [students, setStudents] = useState([]);
  const [isFetching, setIsFetching] = useState(true); // Define isFetching state
  const [isAddStudentModalVisible,setIsAddStudentModalVisible] = useState(false);

  const commonElements= ()=>(
    <div>
     <Modal
            title='Add new Student'
            visible={isAddStudentModalVisible}
            onOk={closeAddStudentModal}
            onCancel={closeAddStudentModal}
            width={1000}>
                <AddStudentForm
                onSuccess={()=>{
                  closeAddStudentModal();
                  fetchStudents();

                }}
                onFailure={(error)=>{
                  console.log(JSON.stringify(error));

                  const message = error.message || "An unexpected error occurred";
                  const errorDescription = (error.error && error.error.message) || "Unknown error description";
                  const status = (error.error && error.error.httpStatus) || "Unknown status";
                
                  errorNotification(status, message, errorDescription);

                }}
                />
           </Modal>
           <Footer 
           numberOfStudents={students.length}
           handleAddStudentClickEvent={openAddStudentModal}
           />
           </div>

  );

  const columns = [
    {
      title:'',
      key: 'avatar',
      render: (text,student)=>(
        <Avatar size='large'>
          {`${student.firstName.charAt(0).toUpperCase()}${student.lastName.charAt(0).toUpperCase()}`}
        </Avatar>
      )
    }
    ,
    {
      title: 'Student ID',
      dataIndex: 'studentId',
      key: 'studentId',
    },
    {
      title: 'First Name',
      dataIndex: 'firstName',
      key: 'firstName',
    },
    {
      title: 'Last Name',
      dataIndex: 'lastName',
      key: 'lastName',
    },
    {
      title: 'Gender',
      dataIndex: 'gender',
      key: 'gender',
    },
    {
      title: 'Email',
      dataIndex: 'email',
      key: 'email',
    },
  ];
  


  useEffect(() => {
    fetchStudents();
  }, []);
 
  const openAddStudentModal = () => {
    setIsAddStudentModalVisible(true);
  };

  const closeAddStudentModal = () => {
    setIsAddStudentModalVisible(false);
  };

  // const fetchStudents = () => {
  //   getAllStudents()
  //     .then(res => res.json())
  //     .then(students => {
  //       setStudents(students);
  //       setIsFetching(false); // Update isFetching state after fetching data
  //     })
  //     .catch(error => {
  //       const message = error.message;
  //       const errorDescription = error.error.message;
  //       const status = error.error.httpStatus;
     
  //       errorNotification(status,message,errorDescription);
  //       setIsFetching(false); // Update isFetching state if there's an error
  //     });
  // };
  const fetchStudents = () => {
    getAllStudents()
      .then(res => res.json())
      .then(students => {
        setStudents(students);
        setIsFetching(false); // Update isFetching state after fetching data
      })
      .catch(error => {

        const message = error.message || "An unexpected error occurred";
        const errorDescription = (error.error && error.error.message) || "Unknown error description";
        const status = (error.error && error.error.httpStatus) || "Unknown status";
      
       
        errorNotification(status, message, errorDescription);
        setIsFetching(false); // Update isFetching state if there's an error
      });
  };
  
  return (
    <div>
     {isFetching ? (
        <Container>
          <Spinner />
        </Container>
      ) : 
        students.length === 0 ? (
          // <div>No students found</div>
          <Container>
          <Empty description={
            <h1> No students found</h1>
          }></Empty>
          {commonElements()}
          
        </Container>
        ) : (
          <Container>
          
          <Table 
          style={{marginBottom:'100px'}}
          dataSource={students} 
          columns={columns}
          // pagination={false}
           rowKey='studentId'/>
          {commonElements()}
           </Container>
          
        )}
          </div>
  );
}


export default App;
