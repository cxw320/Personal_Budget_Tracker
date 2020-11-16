
import React from 'react';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';



const StackedBarChart = () =>{
    const data = [
        {name: 'Jan-20', food: 4000, rent: 2400, amt: 2400},
        {name: 'Feb-20', food: 3000, rent: 1398, amt: 2210},
        {name: 'Mar-20', food: 2000, rent: 9800, amt: 2290},
        {name: 'Apr-20', food: 2780, rent: 3908, amt: 2000},
        {name: 'May-20', food: 1890, rent: 4800, amt: 2181},
        {name: 'Jun-20', food: 2390, rent: 3800, amt: 2500},
        {name: 'Jul-20', food: 3490, rent: 4300, amt: 2100},
  ];

  	return (
       
        <BarChart width={600} height={300} data={data}
            margin={{top: 20, right: 30, left: 20, bottom: 5}}>
        <CartesianGrid strokeDasharray="3 3"/>
        <XAxis dataKey="name"/>
        <YAxis/>
        <Tooltip/>
        <Legend />
        <Bar dataKey="food" stackId="a" fill="#8884d8" />
        <Bar dataKey="rent" stackId="a" fill="#82ca9d" />
        </BarChart>
    
    );
  
};

export default StackedBarChart;