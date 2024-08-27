const  checkStatus = response =>{
    if (response.ok){
        return response;
    }
    // makes the asynchronous nature of the error handling more explicit.
        else {    
            return new Promise((resolve, reject) => {
                let error = new Error(response.statusText);
                error.response = response;
                response.json().then(e => {
                    error.error = e;
                    reject(error); // Reject the Promise with the fully initialized error
                });
            });
        }
    };
    
export const getAllStudents = () => 
            fetch('/api/v1/students').then(checkStatus);

export const addNewStudent = student =>
     fetch('/api/v1/students',{
        headers: {
            'Content-Type':'application/json'
        },
        method:'POST',
        body: JSON.stringify(student)
     }).then(checkStatus);