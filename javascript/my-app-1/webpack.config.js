const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
(() => {
    console.log('webpack worked')
})()
module.exports = {
    entry: "./src/index.js", // Entry point of your application
    mode: 'development',
    output: {
        filename: "bundle.js", // Output bundle file name
        path: path.resolve(__dirname, "dist"), // Output directory
        publicPath: '/'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [
                    {
                        loader: 'babel-loader',
                        options: {
                            presets: [
                                "@babel/preset-env",
                                ["@babel/preset-react", {"runtime": "automatic"}]
                            ]
                        }
                    }
                ]
            },
            {
                test: /\.(css|less)$/,
                use: ["style-loader", "css-loader"]
            },
            {
                test: /\.svg$/,
                loader: "file-loader"
            }
        ],
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: "./public/index.html"
        })
    ],
    devServer: {
        historyApiFallback: true
    },
    resolve: {
        extensions: [".js", ".jsx"],
    },
    // devServer: {
    //     historyApiFallback: true,
    //     static: {
    //         directory: path.join(__dirname, 'dist')
    //         //staticOptions: {},
    //
    //         // Don't be confused with `devMiddleware.publicPath`, it is `publicPath` for static directory
    //         // Can be:
    //         // publicPath: ['/static-public-path-one/', '/static-public-path-two/'],
    //         //publicPath: "/public/",
    //
    //         // Can be:
    //         // serveIndex: {} (options for the `serveIndex` option you can find https://github.com/expressjs/serve-index)
    //         //serveIndex: true,
    //
    //         // Can be:
    //         // watch: {} (options for the `watch` option you can find https://github.com/paulmillr/chokidar)
    //         //watch: true,
    //     },
    //     port: 3000, // Port for the development server
    //     open: true, // Open the default web browser when the server starts
    // },
};

