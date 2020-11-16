import React, {useState, useEffect} from 'react';
import API from "./utils/API";
import Button from 'react-bootstrap/Button';

const EditTransaction = ({id, description, category, amount,callback,toggleEditForm}) => {


    /*const id_string = JSON.stringify (id);
    const desc_string = Object.values(description);*/

    const transactionDefault = {
        id: id,
        description: description,
        category: category,
        amount: amount
    }

    const [transaction, setTransaction] = useState(transactionDefault);

    const saveTransaction = async (ev) => {
        ev.preventDefault();
        let res = await API.post('/transactions', transaction);
        
        if (typeof callback !== 'undefined') {
            callback(res);
        }
        console.log("this is the transaction sent");
        console.log(transaction);
        toggleEditForm();
    }

    const updateState = (property, value) => {
        const t = JSON.parse(JSON.stringify(transaction)); /* converting transaction (which isnt an object
            its an Observer (its own data type) into a string, then converting that string into a json object 
            so that we can edit the values and assign to the property and then pass that json object
            into the setTransaction function to update the transaction state variable*/    
       
            t[property] = value;

            console.log(transaction);
        setTransaction(t)
    }


  return(

        <form onSubmit={saveTransaction}>

                <span>
                <label> Description</label>
                <input type="text" placeholder={description} onChange={e => updateState("description",e.target.value)}/>
                </span>

                <span>
                <label> Category</label>
                <input type="text" placeholder={category} onChange={e => updateState("category",e.target.value)}/>
                </span>

                <span>
                <label> Amount</label>
                <input type="number" placeholder={amount} onChange={e => updateState("amount",e.target.value)}/>
                </span>

            <button type="submit"> Save</button>
        
        </form>

    );


};


export default EditTransaction;