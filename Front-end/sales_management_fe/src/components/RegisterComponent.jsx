import { useNavigate, useHistory } from "react-router-dom";
import React,{useCallback, useEffect, useState} from 'react';
import UserService from "../services/UserService";
import HeaderComponent from "./HeaderComponent";
function RegisterComponent(props) {
    // let navigate=useNavigate();
    let history = useHistory;
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
            setError("Vui lòng nhập tên tài khoản !!!")
        else if(email==="")
        setError("Vui lòng nhập email !!!")
        else if(password==="")
            setError("Vui lòng nhập mật khẩu!!!")
        else if(repass==="")
            setError("Vui lòng xác nhận lại mật khẩu !!!")
        else if(password===repass){
            let acc={
                username:username,
                password:password,
                email:email,
            }
            UserService.createAccount(acc).then(res=>{
                if(res.data.status!=="Fail"){
                    alert("ĐĂng ký thành công!!!");
                    // navigate("/");
                    props.history.push('/')
                } else {
                    setError(res.data.message);
                }
            });
        } else {
            setError("Xác nhận mật khẩu không phù hợp !!!")
        }
    },[username, password, email, repass]);
    // const login=useCallback(()=>navigate('/login'),[navigate]);
    const login=useCallback(()=>props.history.push('/login'));
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
            {/* <HeaderComponent/> */}
                <br></br>
                <div className='container'>
                    <div className='row'>
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center"> ĐĂNG KÝ </h3>
                            <label style={{color:"orange",textAlign:"center"}}>{error}</label>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group' style={{textAlign:"left"}}>  
                                        <label>Tên tài khoản: </label>                           
                                        <input type="text" placeholder="Tên tài khoản" className='form-control' value={username} onChange={enterUsername}/><br></br>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Email: </label> 
                                        <input type="text" placeholder="Email" className='form-control' value={email} onChange={enterEmail}/><br></br>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Mật khẩu: </label> 
                                        <input type="password" placeholder="Mật khẩu" className='form-control' value={password} onChange={enterPassword}/><br></br>
                                    </div>
                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Nhập lại mật khẩu: </label> 
                                        <input type="password" placeholder="Nhập lại mật khẩu" className='form-control' value={repass} onChange={enterRepass}/><br></br>
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

                                    <button className="btn btn-success" style={{width: "100%"}} onClick={register} >ĐĂNG KÝ</button>
                                    <div style={{textAlign:"left"}}>
                                    ĐÃ có tài khoản? <button className="btn btn-link" onClick={login} >Đăng nhập ở đây</button>
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