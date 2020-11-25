
import React, {useState, useEffect} from 'react';
import API from "./utils/API";
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';



const StackedBarChart = () =>{

    const [chartData, setChartData] = useState([]);

    useEffect(()=>{
        loadChartData().then(()=>{
          console.log('chart data loaded')
        })
      },[])

    const loadChartData = async () => {
        const chartData = await API.get('/transactions/MonthSummary');
        setChartData(chartData)
        console.log(chartData);
      }

    const data = [
        {name: 'Jan-20', food: 100, rent: 200},
        {name: 'Mar-20', food: 100, rent: 200},
        {name: 'Apr-20', food: 100, rent: 200},
        {name: 'May-20', food: 100, rent: 200},
        {name: 'Jun-20', food: 100, rent: 200},
        {name: 'Jul-20', food: 100, rent: 200},
  ];
 

  	return (
       
        <BarChart width={600} height={300} data={chartData}
            margin={{top: 20, right: 30, left: 20, bottom: 5}}>
        <CartesianGrid strokeDasharray="3 3"/>
        <XAxis dataKey="name"/>
        <YAxis/>
        <Tooltip/>
        <Legend />
        <Bar dataKey="amount" stackId="a" fill="#8884d8" />
        <Bar dataKey="rentAmount" stackId="a" fill="#82ca9d" />
        </BarChart>
    
    );
  
};

export default StackedBarChart;