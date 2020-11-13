import logo from './logo.svg';
import React, {useState, useEffect} from 'react';
import Transaction from './Transaction.js';
import AddTransaction from './AddTransaction.js';
import API from "./utils/API";

const App = () =>{


  const [transactionList, setTransactionList] = useState([]);

  useEffect(()=>{
    loadTransactions().then(()=>{
      console.log('transactions loaded')
    })
  },[])


  const loadTransactions = async () => {
    const transactions = await API.get('/transactions/all');
    setTransactionList(transactions)
  }


  return (

  <main>  

    <AddTransaction callback={loadTransactions}/>

    <table>
       <thead>
         <tr>
           <th>Description</th>
           <th>Category</th>
           <th>Amount</th>
         </tr>
       </thead>
      <tbody>

        {transactionList.map((transaction)=>(
          <Transaction  id={transaction.id} description={transaction.description}
          category={transaction.category} amount={transaction.amount}  />
        ))
      }
        
      </tbody>
    </table>

  </main>


  )


};


export default App;
