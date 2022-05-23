import React, { Component } from 'react';
import { useState } from 'react';
import { useNavigate,Link, useHistory } from 'react-router-dom';
import {Navbar, Nav, Container, NavDropdown, FormControl, Form, Button} from 'react-bootstrap';
import searchIcon from '../SVG/search.svg';
import accIcon from '../SVG/acc.svg';
import Dropdown from 'react-bootstrap/Dropdown';
import Modal from 'react-bootstrap/Modal';
// import Button from 'react-bootstrap/Button';
// import Form from 'react-bootstrap/Form';

function HeaderComponent(props){
    
    // let navigate=useNavigate;
    let history= useHistory
    const logout=()=>{
        localStorage.removeItem("token");
        localStorage.removeItem("accid");
        localStorage.removeItem("username");
        // navigate("/");
    };

    // const [loading, setLoading] = useState(false);
    // const [key, setKey] = useState("");

    // const changeKeyWord = (e) => {
    //     setKey(e.target.value)
    // }

    const getLogin=()=>{
        // setLoading(true);
        if(localStorage.getItem("username") === null){
            return <Nav.Link as={Link} to= "login">Đăng nhập</Nav.Link>
        }else{
            return <Dropdown>
                    <Dropdown.Toggle variant="warning">
                    <label><img src={accIcon} alt="logo"/> {localStorage.getItem("username")}</label>
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                    <Dropdown.Item href="#">
                        <button onClick={() => props.history.push('/changeinfo')} style={{border:"none",background:"none"}}><Link style={{"text-decoration":"none"}} to="/changeinfo">Thông tin cá nhân</Link></button>
                    </Dropdown.Item>
                    <Dropdown.Item href="#">
                        <button onClick={logout} style={{border:"none",background:"none"}}><Link style={{"text-decoration":"none"}} to="/changePass">Lịch sử đặt hàng</Link></button>
                    </Dropdown.Item>
                    <Dropdown.Item href="#">
                        <button onClick={logout} style={{border:"none",background:"none"}}><Link style={{"text-decoration":"none"}} to="/">Đăng xuất</Link></button>
                    </Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
        }
    }
    return(
           
        <div>
            <header>
                <>
                    <Navbar bg="dark" variant="dark">
                    <Container>
                        <Navbar.Brand as={Link} to= "/">Spring Shop</Navbar.Brand>
                        <Nav className="me-auto">
                            <Nav.Link as={Link} to= "#">Giày Nam</Nav.Link>
                            <Nav.Link as={Link} to= "#">Giày nữ</Nav.Link>
                            <Nav.Link as={Link} to= "#">Balo- Túi</Nav.Link>
                            <Nav.Link as={Link} to= "#">Phụ kiện</Nav.Link>
                            <Form className="d-flex" style={{marginLeft: "100px"}}>
                                {/* <FormControl type="search" placeholder="Search" className="me-2"              aria-label="Search"
                                />
                                <Button variant="outline-success">Search</Button> */}
                                {/* <input type="text" value={key} className="form-control" onChange={changeKeyWord} id="inputPassword2" placeholder="Search Post" />
                                <button className="btn btn-dark" onClick={() => props.history.push(`/home/key=${key}`)} ><img src={searchIcon} alt="logo" /></button> */}
                            </Form>
                        </Nav>
                        <Nav className ='narbar-right'>
                            <Nav.Link >Giỏ hàng</Nav.Link>
                            
                            {getLogin()}
                            
                            
                        </Nav>
                        </Container>
                    </Navbar>
                    
                    </>

                    
            </header>
        </div>
    );

}

export default HeaderComponent;