import React from "react";
import { Formik  } from "formik";
import { Input,Button,Tag } from "antd";
import { addNewStudent } from "../client";

const inputButtonMargin = { marginBottom: '10px' };
const tagStyle = { backgroundColor: 'red', color: 'white', ...inputButtonMargin };


const AddStudentForm= (props)=> (

                <Formik 
                initialValues={{ firstName:'',lastName:'', email: '',gender:''}}
                validate={values => {
                    const errors = {};
                    
                    if(!values.firstName){
                        errors.firstName='First Name Required!'
                    }
                    
                    if(!values.lastName){
                        errors.lastName='Last Name Required!'
                    }

                    if (!values.email) {
                    errors.email = 'Email Required';
                    } else if (
                    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
                    ) {
                    errors.email = 'Invalid email address';
                    }

                    if(!values.gender){
                        errors.gender='Gender Required!';
                    }else if(!['MALE','FEMALE'].includes(values.gender.toUpperCase())){
                        errors.gender="Gender must be ('MALE','FEMALE')";
                    }


                    return errors;
                }}

                onSubmit={(student, { setSubmitting ,resetForm}) => {
                    console.log("Submitting form with values:", student);

                    console.log("Form submission successful");


                    // Transform gender to uppercase
                    student.gender = student.gender.toUpperCase();

                    // console.log("Form submitted with values:", student);

                    // alert(JSON.stringify(student, null, 2));
                    addNewStudent(student).
                    then(()=>{
                        // alert(JSON.stringify(student))
                        // console.log("Form submission successful");

                        // Clear the form
                         resetForm();

                        // Call the onSuccess callback to close the form
                        props.onSuccess(); 
                    })
                    .catch(error => {
                        // Handle any errors
                        props.onFailure(error);
                        console.error('Error adding student:', error);
                    })
                    .finally(() => {
                        // Reset the form submission state
                        setSubmitting(false);
                    });
                    
                }}

                
                >
                {({
                    values,
                    errors,
                    touched,
                    handleChange,
                    handleBlur,
                    handleSubmit,
                    isSubmitting,
                    submitForm,
                    isValid
                    /* and other goodies */
                }) => (
                        <form onSubmit={handleSubmit}>
                        <Input
                            style={inputButtonMargin}
                            name="firstName"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.firstName}
                            placeholder="First name. E.g John"
                        />
                        {errors.firstName && touched.firstName && <Tag style={tagStyle}>{errors.firstName}</Tag>}
                        <Input
                            style={inputButtonMargin}
                            name="lastName"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.lastName}
                            placeholder="Last name. E.g Johnes"
                        />
                        {errors.lastName && touched.lastName &&  <Tag style={tagStyle}>{errors.lastName}</Tag>}
                        <Input
                            style={inputButtonMargin}
                            name="email"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.email}
                            placeholder="Email E.g John@gmail.com"
                        />
                        {errors.email && touched.email && <Tag style={tagStyle}>{errors.email}</Tag>}
                        <Input
                            style={inputButtonMargin}
                            name="gender"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.gender}
                            placeholder="Gender. E.g FEMALE or MALE"
                        />
                        {errors.gender && touched.gender && <Tag style={tagStyle}>{errors.gender}</Tag>}
                       
                        <Button 
                            onClick={()=>{
                                        submitForm();
                                        // alert(JSON.stringify(values, null, 2));
                                    }}

                                type="submit"            
                                style={{ backgroundColor: isSubmitting || (touched && !isValid) ? 'grey' : 'green',
                                         color: 'white'
                                       }}
                                disabled={isSubmitting | (touched && !isValid)}>
                            Submit
                        </Button>

                       

                        </form>
                )}
                </Formik>
           
    );


export default AddStudentForm;