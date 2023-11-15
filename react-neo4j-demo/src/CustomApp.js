import React from "react";
import ReactFlow, {
  ConnectionLineType,
  useNodesState,
  useEdgesState,
} from "reactflow";

import { SWIMLANE_GROUP_NODES } from "./nodes-edges";
import "reactflow/dist/style.css";

const nodeWidth = 100;
const nodeRank = 30;
const nodeHeight = 45;
const swimlaneHeight = 110;
const swimlaneRank = 5;
const edgeType = ConnectionLineType.Bezier;

const processSwimlaneNodes = (inputData) => {
  let maxLength = nodeWidth + nodeRank * 2;

  inputData.forEach((sm) => {
    if (
      maxLength <
      sm.children.length * nodeWidth + (sm.children.length + 1) * nodeRank
    ) {
      maxLength =
        sm.children.length * nodeWidth + (sm.children.length + 1) * nodeRank;
    }
  });

  let swimlanes = [];
  inputData.forEach((input, index) => {
    swimlanes.push({
      id: input.id,
      data: {
        label: input.name,
      },
      position: {
        x: 0,
        y: swimlaneHeight * index,
      },
      style: {
        height: swimlaneHeight-swimlaneRank,
        width: maxLength,
        zIndex: -1,
        background: "grey",
        textAlign: "left",
        color: "#16fae7",
        fontWeight: 600
      },
    });
  });
  return swimlanes;
};

const processChildrenNodes = (inputData) => {
  let childrenNodes = [];
  inputData.forEach((input, index) => {
    const childrenYPosition =
      swimlaneHeight * index + swimlaneHeight / 2 - nodeHeight / 2;

    input.children.forEach((child, index1) => {
      childrenNodes.push({
        id: child.id,
        data: {
          label: child.name,
        },
        position: {
          x: nodeRank * (index1 + 1) + index1 * nodeWidth,
          y: childrenYPosition,
        },
        style: {
          zIndex: 0,
          background: "yellow",
          width: nodeWidth,
          height: nodeHeight,
        },
      });
    });
  });
  return childrenNodes;
};

const getLayoutedElements = async (inputData) => {
  let nodes = [];
  let edges = [
    {
      id: "21-31",
      source: "21",
      type: edgeType,
      target: "31",
      style: {
        zIndex: 2,
      },
    },
    {
      id: "21-41",
      source: "21",
      type: edgeType,
      target: "41",
      style: {
        zIndex: 2,
      },
    },
    {
      id: "21-42",
      source: "21",
      type: edgeType,
      target: "42",
      style: {
        zIndex: 2,
      },
    },
    {
      id: "21-43",
      source: "21",
      type: edgeType,
      target: "43",
      style: {
        zIndex: 2,
      },
    },
    {
      id: "43-32",
      source: "43",
      type: edgeType,
      target: "32",
      style: {
        zIndex: 2,
      },
    },
    {
      id: "33-11",
      source: "33",
      type: edgeType,
      target: "11",
      style: {
        zIndex: 2,
      },
    },
    {
      id: "22-35",
      source: "22",
      type: edgeType,
      target: "35",
      style: {
        zIndex: 2,
      },
    },
  ];

  const swimlaneNodes = processSwimlaneNodes(inputData);
  nodes = nodes.concat(swimlaneNodes);
  const childrenNodes = processChildrenNodes(inputData);
  nodes = nodes.concat(childrenNodes);
  return { layoutNodes: nodes, layoutEdges: edges };
};

const { layoutNodes, layoutEdges } = await getLayoutedElements(
  SWIMLANE_GROUP_NODES
);

const LayoutFlow = () => {
  console.warn(layoutNodes);
  const [nodes] = useNodesState(layoutNodes);
  const [edges] = useEdgesState(layoutEdges);
  return (
    <ReactFlow
      nodes={nodes}
      edges={edges}
      connectionLineType={ConnectionLineType.Bezier}
      fitView
    />
  );
};

export default LayoutFlow;
