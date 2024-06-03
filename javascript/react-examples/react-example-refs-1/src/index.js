import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App'
import RefsComponent from "./RefsComponent"
import AutoFocusTextInput from "./AutoFocusTextInput";
import CustomTextInput from "./CustomTextInput";
import UseRefCustomTextInput from './UseRefCustomTextInput';
import {CallBackCustomTextInput} from './CallBackCustomTextInput'
// import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <UseRefCustomTextInput />
        <hr />
        <CustomTextInput/>
        <hr/>
        <RefsComponent/>
        <hr/>
        <App/>
        <hr/>
        <CallBackCustomTextInput />
        <hr />
        <AutoFocusTextInput/>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();
