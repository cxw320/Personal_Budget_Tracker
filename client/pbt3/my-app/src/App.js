import logo from './logo.svg';
import React, {useState, useEffect} from 'react';
import './App.css';
import Transaction from './Transaction.js';

const App = () =>{

  const dummyData = [ 
    { id: 1,
      description: 'test',
      category: 'test',
      amount: 100},
    { id: 2,
      description: 'store',
      category: 'food',
      amount: 200}
  ]


  const [transactionList, setTransaction] = useState(dummyData);

  var transactions = transactionList.map((transaction) =>{
      const{id, description, category, amount} = transaction;

      return( 

          <Transaction id={id} description={description} category={category}
                amount={amount}/>

      )    

  });




  return (

    <table>
       <thead>
         <tr>
           <th>Description</th>
           <th>Category</th>
           <th>Amount</th>
         </tr>
       </thead>
      <tbody>
        {transactions}
      </tbody>
    </table>


  )


};


export default App;
