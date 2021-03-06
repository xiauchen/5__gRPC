/*
 *
 * Copyright 2015 gRPC authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
var PROTO_PATH = __dirname + '/helloworld.proto';
var async = require('async');
var grpc = require('grpc');
var _ = require('lodash');
var protoLoader = require('@grpc/proto-loader');
var packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {keepCase: true,
     longs: String,
     enums: String,
     defaults: true,
     oneofs: true
    });
    //routeguide 要改
var helloworld = grpc.loadPackageDefinition(packageDefinition).helloworld;
var client = new helloworld.Greeter('localhost:49993',
                                       grpc.credentials.createInsecure());
function runRouteChat(callback) {
	// var client = new services.GreeterClient('localhost:49993',
  //                                         grpc.credentials.createInsecure());
  // var request = new messages.HelloRequest();
  // var user;
  // if (process.argv.length >= 3) {
  //   user = process.argv[2];
  // } else {
  //   user = 'world';
  // }
  // request.setName(user);
  // for (var i = 0; i < 10; i++) {
  // client.helloWorld(request, function(err, response) {
  //   console.log('Greeting:', response.getMessage());
  // });
 
  //////////////////////////////////////////////////////////////////
  var call = client.helloWorldClientAndServerStream();
  //note 回來的值
  call.on('data', function(note) {
    console.log('Got message "' + note.message + '" at ');
  });
  call.on('end', callback);
  var notes = [{
    name: 'First message'
  }, {
    name: 'Second message'
  }, {
    name: 'Third message'
  }, {
    name: 'Fourth message'
  }];
  //notes 丟出去的值
  for (var i = 0; i < notes.length; i++) {
    var note = notes[i];
    console.log('Sending message "' + note.name + '" at ' );
    call.write(note);
  }
  call.end();
}

function main() {
  async.series([
    runRouteChat
  ]);
}

if (require.main === module) {
  main();
}

exports.runRouteChat = runRouteChat;
//main();
