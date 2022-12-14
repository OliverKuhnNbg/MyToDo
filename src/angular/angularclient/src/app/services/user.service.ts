import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
	
	private usersUrl: string;

  	
	constructor(private http: HttpClient) {
		this.usersUrl = 'http://localhost:8083/users';
	}

	public findAll(): Observable<User[]> {
		return this.http.get<User[]>(this.usersUrl);
	}
	public save(user: User) {
    	return this.http.post<User>('http://localhost:8083/save-user', user);
    }
}
