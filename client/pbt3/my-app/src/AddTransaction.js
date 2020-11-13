import React, {useState, useEffect} from 'react';
import API from "./utils/API";
import './App.css';


const AddTransaction = ({callback}) => {
    const transactionTemplate = {
        description: '',
        category: '',
        amount: 0
    }
    const [transaction, setTransaction] = useState(transactionTemplate);

    const submitHandler = async (ev) => {
        ev.preventDefault();
        let res = await API.post('/transaction/', transaction);
        setTransaction(transactionTemplate);
        if (typeof callback !== 'undefined') {
            callback(res);
        }
    }

    const updateState = (property, value) => {
        const t = JSON.parse(JSON.stringify(transaction));
        t[property] = value;
        setTransaction(t)
    }


    return (

        <form onSubmit={submitHandler}>
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