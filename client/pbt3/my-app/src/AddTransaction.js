import React, {useState, useEffect} from 'react';
import API from "./utils/API";


const AddTransaction = ({callback}) => {
    const transactionTemplate = {
        description: '',
        category: '',
        amount: 0
    }
    const [transaction, setTransaction] = useState(transactionTemplate);

    const saveTransaction = async (ev) => {
        ev.preventDefault();
        console.log(transaction);
        let res = await API.post('/transactions', transaction);
        setTransaction(transactionTemplate);
        
        if (typeof callback !== 'undefined') {
            callback(res);
        }
    }

    const updateState = (property, value) => {
        const t = JSON.parse(JSON.stringify(transaction)); /* converting transaction (which isnt an object
            its an Observer (its own data type) into a string, then converting that string into a json object 
            so that we can edit the values and assign to the property and then pass that json object
            into the setTransaction function to update the transaction state variable*/    
       t[property] = value;
        setTransaction(t)
    }


  return(

        <form onSubmit={saveTransaction}>
            {Object.keys(transactionTemplate).map(property => (
                <div key={property}>
                    <label> {property.toUpperCase()} </label>
                    <input type="text" value={transaction[property]}
                           onChange={e => updateState(property, e.target.value)}/>
                </div>
            ))}


            <button type="submit"> Add Transaction</button>
        
        </form>

    );


};


export default AddTransaction;