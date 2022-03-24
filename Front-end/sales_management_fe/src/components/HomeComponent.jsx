import React from "react";
import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import CategoryService from "../services/CategoryService";
import ProductService from "../services/ProductService";
import { useEffect } from 'react';

// import Card from 'react-bootstrap/Card';
// import Modal from 'react-bootstrap/Modal';
// import Button from 'react-bootstrap/Button';
// import Dropdown from 'react-bootstrap/Dropdown';


function HomeComponent() {
    let navigate=useNavigate();
    const[result1,setResult1]=useState([]);
    const[result2,setResult2]=useState([]);

    // useEffect(()=>{
    //     CategoryService.getCategories().then(res=>{
    //         if(res.data!==null){
    //             setResult1(res.data);}
    //     });
    // },[result1]);

    useEffect(()=>{
        ProductService.getProducts().then(res=>{
            if(res.data!==null){
                setResult1(res.data);}
        });
        CategoryService.getCategories().then(res=>{
            if(res.data!==null){
                setResult2(res.data);}
            // } else {
            //     setResult("No topic is created")
            // }
        });
        // if(localStorage.getItem("role")!=="user")
        //     setCanAddTopic(true);
    },[result1,result2]);
    return(
        <div style={{marginLeft: "2%", marginRight:"2%"}}>
            <br></br>
            <table style={{border:"none"}}>
                <td style={{width:"1100px"}}>
                     <table>
                
                         {
                            result1.map(
                                product=>
                                <tr key={product.id}>
                                    <td>
                                        
                                            <img src={product.image} style={{height: "300px"}} alt="image" /><br></br> 
                                            <b>{product.name}</b><br></br>
                                            {product.price} VNĐ<br></br> 
                                                                     
                                    </td>
                                </tr>
                            )
                            }
                        
                     </table>

                   
                </td>
                <td style={{width:"250px", verticalAlign:"top"}}>
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Loại sản phẩm</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                            result2.map(
                                category=>
                                <tr key={category.id}>
                                    <td>
                                        {category.name}
                                    </td>
                                </tr>
                            )
                            }
                        </tbody>
                    </table>
                </td>
            </table>
        </div>

    );
}
export default HomeComponent;