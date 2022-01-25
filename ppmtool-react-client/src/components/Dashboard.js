import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import CreateProjectButton from "./Project/CreateProjectButton";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />
              <CreateProjectButton />
                    <h1>Burlap sack full of kids</h1>
                    <h2>Not my kids</h2>
              <br />
              <hr />
              <ProjectItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;