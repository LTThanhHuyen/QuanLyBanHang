import React, { Component } from "react";
import { useState } from 'react';
import { useNavigate, useHistory } from "react-router-dom";
import CategoryService from "../services/CategoryService";
import ProductService from "../services/ProductService";
import { useEffect } from 'react';
import HeaderComponent from "./HeaderComponent";

// import Card from 'react-bootstrap/Card';
// import Modal from 'react-bootstrap/Modal';
// import Button from 'react-bootstrap/Button';
// import Dropdown from 'react-bootstrap/Dropdown';


function HomeComponent(props) {
    

    // let navigate=useNavigate();
    let history = useHistory;
    const[result1,setResult1]=useState([]);
    const[result2,setResult2]=useState([]);

    // const viewProductDetail=(id)=>{navigate(`/view-product/${id}`)};

    const viewProductDetail=(id) => {
        props.history.push(`/view-product/${id}`);
        // console.log(props);
    }

    useEffect(()=>{
        
        ProductService.getProducts().then(res=>{
            if(res.data!==null){
                setResult1(res.data);}
        });
        CategoryService.getCategories().then(res=>{
            if(res.data!==null){
                setResult2(res.data);}
           
        });
       
    },[result1,result2]);
    return(
        
        <div >
            {/* <HeaderComponent/> */}
            <br></br>
            <table style={{border:"none", marginLeft: "2%", marginRight: "2%"}}>
                <td style={{width:"1100px"}}>
                     {/* <table>
                
                         {
                            result1.map(
                                product=>
                                <tr key={product.id}>
                                    <td>                                       
                                        <img src={product.image} style={{height: "300px"}} alt="image" onClick={()=>viewProductDetail(product.id)} /><br></br> 
                                        <b>{product.name}</b><br></br>
                                        {product.price} VNĐ<br></br> 
                                                                     
                                    </td>
                                </tr>
                            )
                            }
                        
                     </table> */}


                    <div class="row">
                        
                        {     
                            result1.map(
                                product=>   
                                <div key={product.id} className="col-sm-4" style={{textAlign: "center", height: "360px"}}>   
                                    <img src={product.image} style={{height: "300px"}} alt="image" onClick={()=>viewProductDetail(product.id)}/><br></br> 
                                    <b>{product.name}</b><br></br>
                                    {product.price} VNĐ<br></br> 
                                </div>
                            )
                        } 
                        
                    </div>                                   
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