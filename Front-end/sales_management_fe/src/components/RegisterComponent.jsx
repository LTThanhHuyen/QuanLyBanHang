import { useNavigate } from "react-router-dom";
import React,{useCallback, useEffect, useState} from 'react';
import UserService from "../services/UserService";
function RegisterComponent() {
    let navigate=useNavigate();
    
    const[username,setUsername]=useState("");
    const[email,setEmail]=useState("");
    const[password,setPassword]=useState("");
    const[repass,setRepass]=useState("");
    // const[name,setName]=useState("");
    // const[address,setAdress]=useState("");
    // const[phone,setPhone]=useState("");
    
    const[error,setError]=useState("");

    const register=useCallback((e)=>{
        e.preventDefault();
        if (username==="")
            setError("Vui long nhap username !!!")
        else if(email==="")
        setError("Vui long nhap email !!!")
        else if(password==="")
            setError("Vui long nhap password !!!")
        else if(repass==="")
            setError("Vui long xac nhan lai password !!!")
        else if(password===repass){
            let acc={
                username:username,
                password:password,
                email:email,
            }
            UserService.createAccount(acc).then(res=>{
                if(res.data.status!=="Fail"){
                    alert("Dang ky thanh cong !!!");
                    navigate("/");
                } else {
                    setError(res.data.message);
                }
            });
        } else {
            setError("Xac nhan password ko phu hop !!!")
        }
    },[username, password, email, repass]);
    const login=useCallback(()=>navigate('/'),[navigate]);
    const enterUsername=(e)=>{
        setUsername(e.target.value);
    }
    const enterPassword=(e)=>{
        setPassword(e.target.value)
    }
    const enterRepass=(e)=>{
        setRepass(e.target.value)
    }
    // const enterName=(e)=>{
    //     setName(e.target.value)
    // }
    // const enterAddress=(e)=>{
    //     setAdress(e.target.value)
    // }
    // const enterPhone=(e)=>{
    //     setPhone(e.target.value)
    // }
    const enterEmail=(e)=>{
        setEmail(e.target.value)
    }
   
    return(
        

        <div>
                <br></br>
                <div className='container'>
                    <div className='row'>
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center"> Register </h3>
                            <label style={{color:"orange",textAlign:"center"}}>{error}</label>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group' style={{textAlign:"left"}}>  
                                        <label>User name: </label>                           
                                        <input type="text" placeholder="Username" className='form-control' value={username} onChange={enterUsername}/><br></br>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Email: </label> 
                                        <input type="text" placeholder="Email" className='form-control' value={email} onChange={enterEmail}/><br></br>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Password: </label> 
                                        <input type="password" placeholder="Password" className='form-control' value={password} onChange={enterPassword}/><br></br>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Re-Enter passwordPassword: </label> 
                                        <input type="password" placeholder="re-enter password" className='form-control' value={repass} onChange={enterRepass}/><br></br>
                                    </div>
                                    {/* <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Name: </label>
                                        <input type="text" placeholder="Name" className='form-control' value={name} onChange={enterName}/>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Email: </label>
                                        <input type="text" placeholder="Email" className='form-control' value={address} onChange={enterAddress}/>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Email: </label>
                                        <input type="text" placeholder="Email" className='form-control' value={phone} onChange={enterPhone}/>
                                    </div> */}

                                    <button className="btn btn-success" style={{width: "100%"}} onClick={register} >Register</button>
                                    <div style={{textAlign:"left"}}>
                                    Already registered? <button className="btn btn-link" onClick={login} >Login here</button>
                                    </div>
                                     
                                </form>

                            </div>
                        </div>

                    </div>
                </div>
                
            </div>
    );
}
export default RegisterComponent;