import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(username: string, password: string) {
        if (username == "wrong"){
            return false;
        }
        localStorage.setItem('currentUser', JSON.stringify({ 'username': username, 'password': password }));
        console.log('currentUser: ', JSON.parse(localStorage.getItem('currentUser')));
        return true;
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}