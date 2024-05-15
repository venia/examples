
1. Create a folder and initialize NPM
npm init -y

2. Install the following packages
npm i react react-dom
npm i -D @babel/core @babel/preset-env @babel/preset-react babel-loader css-loader html-webpack-plugin sass sass-loader style-loader url-loader webpack webpack-cli webpack-dev-server

3. Create .babelrc file
{
  "presets": ["@babel/preset-env", "@babel/preset-react"]
}

4. Create a webpack.config.js file
const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
  output: {
    path: path.join(__dirname, "/dist"), // the bundle output path
    filename: "bundle.js", // the name of the bundle
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: "src/index.html", // to import index.html file inside index.js
    }),
  ],
  devServer: {
    port: 3030, // you can change the port
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/, // .js and .jsx files
        exclude: /node_modules/, // excluding the node_modules folder
        use: {
          loader: "babel-loader",
        },
      },
      {
        test: /\.(sa|sc|c)ss$/, // styles files
        use: ["style-loader", "css-loader", "sass-loader"],
      },
      {
        test: /\.(png|woff|woff2|eot|ttf|svg)$/, // to import images and fonts
        loader: "url-loader",
        options: { limit: false },
      },
    ],
  },
};

5. Create an /src folder and create the following files inside it

|-- src
  |-- App.js
  |-- App.scss
  |-- index.html
  |-- index.js

6. Create serve and build scripts
In your package.json file, add the following:

7. Run and modify your app
Run the app with npm run serve. Open your browser on http://localhost:3030/. Try to modify it and see the changes on the fly.

8. Build the app
Run npm run build in the terminal. You will see the following output:

|-- dist
  |-- bundle.js
  |-- bundle.js.LICENSE.txt
  |-- index.html 

