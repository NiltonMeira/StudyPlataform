import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'

import{
  RouterProvider,
} from "react-router-dom"

import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify'
import mainRoutes from './routes/mainroutes.tsx'



ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={mainRoutes} />
    <ToastContainer />
  </React.StrictMode>,
)
